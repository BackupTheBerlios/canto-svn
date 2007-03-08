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

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class StatelessProcessImpl extends BaseProcess {

	/**
	 * Subclass this to handle each Event.
	 */
	public void onEvent(Event event) {
	}

	/**
	 * Return a list of ProcessTimers which are ready to pop.
	 * 
	 * This method must not have a transactional context setup.
	 *  
	 * @return a list of ProcessTimers which are ready to pop.
	 */
	public List<ProcessTimer> getReadyTimers( int maxTimers ) {
		return null;
	}
	
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
	public void onTimer( ProcessInstance instance ) {
	}
	
	/**
	 * Called once when initialization is completed - if init-method="onBoot".
	 * 
	 */
	public void onBoot() {
	}
	
}
