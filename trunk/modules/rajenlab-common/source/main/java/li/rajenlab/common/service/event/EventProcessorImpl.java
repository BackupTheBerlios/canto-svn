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

import li.rajenlab.common.domain.event.Event;


/**
 * An EventProcessor implementation which processes events from an
 * EventQueue and dispatches them via an EventDispatcher until there
 * are no Events left in the EventQueue.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventProcessorImpl implements EventProcessor {

	/**
	 * The EventQueue to poll Events from until empty.
	 */
	private EventQueue eventQueue_;
	
	/**
	 * The EventDispatcher to dispatch the polled Events to.
	 */
	private EventDispatcher eventDispatcher_;
	
	public void process() {
		EventDispatcher eventDispatcher = this.eventDispatcher_; // hold ref since changes shouldnt effect dispatching
		EventQueue eventQueue = this.eventQueue_; // hold ref since changes shouldnt effect dispatching
		
		if ( eventQueue == null ) {
			throw new RuntimeException("EventProcessor is missing an eventQueue");
		}
		if ( eventDispatcher == null ) {
			throw new RuntimeException("EventProcessor is missing an eventDispatcher");
		}
		Event event = null;
		do {
			event = eventQueue.poll();
			if ( event != null ) {
				eventDispatcher.dispatch(event);
			}
		} while( event != null );
	}

	public EventQueue getEventQueue() {
		return eventQueue_;
	}

	public void setEventQueue(EventQueue eventQueue) {
		this.eventQueue_ = eventQueue;
	}

	public EventDispatcher getEventDispatcher() {
		return eventDispatcher_;
	}

	public void setEventDispatcher(EventDispatcher eventDispatcher) {
		this.eventDispatcher_ = eventDispatcher;
	}

}
