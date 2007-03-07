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
 * A Service to serialize and deserialize Events.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface EventService {

    /**
     * Serialize Event
     * @param event
     * @return
     */
	public byte[] serialize( Event event );
	
    /**
     * Deserilalize event
     * @param event
     * @return
     */
	public Event deserialize( byte[] event );
}
