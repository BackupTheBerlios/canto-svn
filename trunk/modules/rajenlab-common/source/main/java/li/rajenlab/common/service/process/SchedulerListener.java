/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process;

import java.util.List;

import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface SchedulerListener {

	/**
	 * Return a list of ProcessTimers which are ready to pop.
	 * 
	 * This method must not have a transactional context setup.
	 *  
	 * @return a list of ProcessTimers which are ready to pop.
	 */
	public List<ProcessTimer> getReadyTimers( int maxTimers );
	
	/**
	 * Handle a ProcessTimer popping. 
	 * 
	 * A Scheduler will retrieve a list of ProcessTimers which are ready to pop
	 * with {@link #getReadyTimers(int)} and for each timer call this method.
	 * 
	 * This method must have a NEW transactional context setup for each call.
	 * 
	 * Any Events created in the context of onTimer must also be processed
	 * by calling EventProcessor#process()
	 * 
	 * @param instance the ProcessInstance which has a timer which is ready to pop.
	 */
	public void onTimer( ProcessInstance instance );
	
	/**
	 * Get the maximum number of timers to pop per schedule.
	 * 
	 * After processing the max number of timers the schedule interval
	 * will be slept. Bear in mind that the Scheduler can only be
	 * stopped once the thread is returned.
	 * 
	 * @return the maximum number of timers to process before sleeping.
	 */
	public int getMaxTimersPerSchedule();
	
	/**
	 * Get the maximum number of timers to fetch in one select.
	 * Bear in mind that multiple application instances will potentially select
	 * the same entries - only one will be able to process the timer.
	 * Suggest about 10.
	 * 
	 * @return the maximum number of timers to fetch in one select.
	 */
	public int getMaxTimersPerSelect();
	
}
