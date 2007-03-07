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
 * EventDispatcher can dispatch a single Event.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface EventDispatcher {

	public void dispatch( Event event );
}
