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

package li.rajenlab.common.service.boot;

import java.util.List;

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface BootService {

	/**
	 * Get a list of {@link Bootable} listeners.
	 * 
	 * @return a list of Bootable's
	 */
	public List getListeners();
	
	/**
	 * Set a list of {@link Bootable} listeners.
	 * 
	 * @param a list of Bootable's
	 */
	public void setListeners( List listeners );
	
	/**
	 * Calls the {@link Bootable#onBoot()} method of all listeners.
	 * 
	 * Hookup this method to spring configuration's init-method="onInit".
	 */
	public void onInit();
}
