/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.state;

import li.rajenlab.common.domain.event.Event;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface State {
    
    
    /**
     * The State name.
     * 
     * @return the State name.
     */
    public String getName();
    
    
    /**
     * The Event triggering a transition from this State.
     * 
     * @param event the Event triggering a transition from this State.
     */
    public void setEvent(Event event);
    
    
    /**
     * onEntry code called on entrance to the state **after** a
     * Transition or if this is the initial state, when the state
     * is instantiated.
     */
    public void onEntry();
    
    /**
     * onExit code called on exit from the state **before** a
     * Transition.
     */
    public void onExit();

}
