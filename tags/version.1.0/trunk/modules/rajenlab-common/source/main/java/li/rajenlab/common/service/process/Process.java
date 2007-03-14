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

import li.rajenlab.common.domain.event.EventListener;
import li.rajenlab.common.service.boot.Bootable;



/**
 * A Process is a boot strappable, event processor, which is linked to
 * a Scheduler to provide ProcessInstance timers.
 *  
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface Process extends EventListener, SchedulerListener, Bootable {

	/**
	 * Get the name of the Process.
	 * 
	 * @return the name of the Process.
	 */
	public String getName();
	
}
