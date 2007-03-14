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

import li.rajenlab.common.service.process.state.StateFactory;


/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface StatefullProcess extends Process {

	/**
	 * Return the statefull Processes StateFactory.
	 * 
	 * @return the StateFactory associated with the Process.
	 */
	public StateFactory getStateFactory();
	
}
