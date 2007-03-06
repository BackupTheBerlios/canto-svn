/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.service.chain.ChainException;
import li.rajenlab.common.service.event.chain.EventChainInvoker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * An EventDispatcher implementation which dispatches an Event to
 * an EventChainInvoker depending on the Event's 
 * {@link li.rajenlab.common.domain.event.StandardEventProperties#SEND_TO}
 * URL and the {@link #dispatchMap_} configuration. 
 * 
 * The EventDispatcher's {@link #dispatchMap_} property is configured 
 * through Spring.
 *  
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventDispatcherImpl implements EventDispatcher {

    protected static Log log = LogFactory.getLog(EventDispatcherImpl.class);
    
	/**
	 * A mapping of "SendTo" URL to EventChainInvoker
	 */
	private Map<String,Object> dispatchMap_ = new HashMap<String,Object>();
	
	/**
	 * Flag to raise a runtime error if no URL match takes place.
	 */
	private boolean noMatchCausesErrorFlag_ = false;
	
    /**
     * 
     * @see li.rajenlab.common.service.event.EventDispatcher#dispatch(li.rajenlab.common.domain.event.Event)
     */
	public void dispatch(Event event) {
		String sendTo = event.getProperty(StandardEventProperties.SEND_TO);
		if ( sendTo == null ) {
			throw new RuntimeException("Event does not have a sendTo property.");
		}
		
		// if there is no dispatch and noMatchCausesErrorFlag is true then we
		// cause a runtime error
		boolean dispatched = false;
		
		Iterator invokerIterator = dispatchMap_.keySet().iterator();
		while( invokerIterator.hasNext() ) {
			String url = (String)invokerIterator.next();
			
			if ( sendTo.startsWith(url) ) {
				log.debug("Dispatching to event sendTo " + sendTo+ " to chain invoker for url " + url);
				
				Object invoker = dispatchMap_.get(url);
		        if(!EventChainInvoker.class.isAssignableFrom(invoker.getClass())) {
		            throw new RuntimeException("EventChainInvoker for URL [" + url + "] is not of type EventChainInvoker");
		        }
		        
		        try {
		        	((EventChainInvoker)invoker).invokeChain(event);
		        } catch ( ChainException ce ) {
		        	throw new RuntimeException(ce);
		        }
		        dispatched = true;
			}
		}
		if ( !dispatched && isNoMatchCausesErrorFlag() ) {
			throw new RuntimeException("Event addressed to " + sendTo + " was not dispatched." );
		}
	}

	public Map<String,Object> getDispatchMap() {
		return dispatchMap_;
	}

	public void setDispatchMap(Map<String,Object> dispatchMap) {
		this.dispatchMap_ = dispatchMap;
	}

	public boolean isNoMatchCausesErrorFlag() {
		return noMatchCausesErrorFlag_;
	}

	public void setNoMatchCausesErrorFlag(boolean noMatchCausesErrorFlag) {
		this.noMatchCausesErrorFlag_ = noMatchCausesErrorFlag;
	}

}
