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

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface Bootable {

	/**
	 * Called once when initialization is completed - if init-method="onBoot".
	 * 
	 * Make sure the spring configuration for the bean which 
	 * implements this to be:
	 * 
	 * init-method="onBoot"
	 */
	public void onBoot();
}
