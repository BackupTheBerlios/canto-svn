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

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import li.rajenlab.common.domain.event.Event;



/**
 * An EventQueue implementation which is bound to a Thread. 
 * 
 * Since the implementation is used as a singleton Spring Bean in a 
 * multithreaded environment, if an EventDisatcher dispatches any events
 * from another thread, then events would be processed in different
 * transactions!
 * 
 * @see #threadlocal.
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventQueueImpl implements EventQueue {

	private static ThreadLocal threadlocal = new ThreadLocal() {
		@Override
        protected synchronized Object initialValue() {
            return new ConcurrentLinkedQueue();
        }
	};
	
	@SuppressWarnings("unchecked")
    public synchronized void push(Event event) {
		Queue queue = (Queue)threadlocal.get();
		queue.add(event);
	}

	public synchronized Event poll() {
		Queue queue = (Queue)threadlocal.get();
		return (Event)queue.poll();
	}

}
