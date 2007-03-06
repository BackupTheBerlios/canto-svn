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
 * A Queue for Events. Events can be pushed onto the queue with the {@link #push(Event)}
 * method and polled from the Queue with {@link #poll()}
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface EventQueue {

	/**
	 * Push the Event onto the Queue.
	 * 
	 * @param event the Event.
	 */
	public void push( Event event );
	
	/**
	 * Poll an Event from the Queue without blocking.
	 * 
	 * @return an Event if availible otherwise null.
	 */
	public Event poll();
	
}
