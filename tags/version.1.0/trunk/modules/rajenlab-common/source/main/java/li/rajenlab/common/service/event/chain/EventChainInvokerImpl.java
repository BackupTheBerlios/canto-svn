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

package li.rajenlab.common.service.event.chain;

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.service.chain.Chain;
import li.rajenlab.common.service.chain.ChainException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Invokes a Chain with an EventChainContext holding a single Event.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventChainInvokerImpl implements EventChainInvoker {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    
    protected static Log log = LogFactory.getLog(EventChainInvokerImpl.class);
    
    /**
     * Standard chain implementation.
     */
    private Chain chain_;

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    /**
     * Passes the Event down the Chain in an EventChainContext.
     * 
     * @see EventChainContext
     */
    public void invokeChain(Event event) throws ChainException {
        EventChainContext context = new EventChainContext();
        context.setEvent(event);
        getChain().invoke(context);
    }
    
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------    
    
    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
    public Chain getChain() {
        return chain_;
    }

    public void setChain(Chain chain) {
        chain_ = chain;
    }

}
