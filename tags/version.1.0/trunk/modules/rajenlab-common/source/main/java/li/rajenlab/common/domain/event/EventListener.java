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

package li.rajenlab.common.domain.event;

/**
 * EventListeners receive asynchronous notification of an Event through the
 * onEvent function.

 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface EventListener {

	/**
	 * Process a single Event. The Event may be changed by changing existing
	 * Attachments or adding or removing Attachments during onMessage 
	 * processing.
	 * 
	 * Throwing a RuntimeException will in-general cause a transaction 
	 * rollback on the current transaction context.
	 * 
	 * 
	 * @param event the Event.
	 */
	public void onEvent( Event event );
}
