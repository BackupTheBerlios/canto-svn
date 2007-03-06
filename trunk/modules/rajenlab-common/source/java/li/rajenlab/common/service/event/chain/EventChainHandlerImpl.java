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
import li.rajenlab.common.domain.event.EventListener;
import li.rajenlab.common.service.chain.ChainException;
import li.rajenlab.common.service.chain.Context;
import li.rajenlab.common.service.chain.Handler;


/**
 * A Chain Handler which delegates an Event received in an EventChainContext
 * to an EventListener.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventChainHandlerImpl implements Handler {

	private EventListener listener_;
	
    /**
     * 
     * @see li.rajenlab.common.service.chain.Handler#invoke(li.rajenlab.common.service.chain.Context)
     */
	public void invoke(Context context) throws ChainException {
		if ( listener_ == null ) {
			throw new ChainException("Null listener.");
		}
		if ( context == null ) {
			throw new ChainException("Null context.");
		}
        if(!EventChainContext.class.isAssignableFrom(context.getClass())) {
            throw new ChainException("Context is not of type EventChainContext. " + context.getClass().getName());
        }
		Event event = ((EventChainContext)context).getEvent();
		if ( event == null ) {
			throw new ChainException("EventChainContext has no event.");
		}
        listener_.onEvent(event);
	}

	public EventListener getListener() {
		return listener_;
	}

	public void setListener(EventListener listener) {
		this.listener_ = listener;
	}

}
