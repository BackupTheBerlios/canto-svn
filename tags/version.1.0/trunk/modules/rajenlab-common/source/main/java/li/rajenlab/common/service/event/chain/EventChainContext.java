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
import li.rajenlab.common.service.chain.ContextImpl;



/**
 * An EventContext holding an Event for use with an
 * EventChainInvoker.
 *
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class EventChainContext extends ContextImpl {

    public static final String EVENT_PROPERTY = "EVENT_PROP";
    
    public EventChainContext() {
    }
    
    public void setEvent(Event event) {
        setProperty(EVENT_PROPERTY, event);
    }

    public Event getEvent() {
        return (Event)getProperty(EVENT_PROPERTY);
    }

}
