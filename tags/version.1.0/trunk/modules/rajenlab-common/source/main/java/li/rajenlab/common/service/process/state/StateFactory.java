/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process.state;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface StateFactory {
    
    
    /**
     * Returns a new instance ( non-singleton ) State with the given name.
     * 
     * @param stateName the state name.
     * @return the State.
     */
    public State getState( String stateName );
    
    /**
     * Return the initial State associated with the StateFactory.
     * 
     * @return the initial State.
     */
    public State getInitialState();
    
    /**
     * Return the final State associated with the StateFactory.
     * 
     * @return the final State.
     */
    public State getFinalState();
    
    /**
     * The method to call on each State in case of a timer trigger. The 
     * method name must be the same for each State in the Factory.
     * 
     * @return the method name of the timer trigger.
     */
    public String getTimerMethodName();

}
