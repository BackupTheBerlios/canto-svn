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

import java.util.Iterator;
import java.util.List;

/**
 * A Service to Bootstrap other Bootable beans. Register any Bootable beans
 * with the service in the spring configuration. The spring configuration 
 * of the BootServiceImpl bean must have init-method="onInit" set.
 * 
 * This is used instead of simply
 * having an init-method="method" on each "bootable" bean because if the method is
 * transactional, the the method call must come from outside the bean, through
 * the transaction proxy to initiate the transaction.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class BootServiceImpl implements BootService {

	private List listeners_;
	
	public List getListeners() {
		return this.listeners_;
	}

	public void setListeners(List listeners) {
		this.listeners_ = listeners;
	}

	public void onInit() {
		if ( getListeners() != null ) {
			Iterator iterator = getListeners().iterator();
			while( iterator.hasNext()) {
				Object l = iterator.next();
		        if(!Bootable.class.isAssignableFrom(l.getClass())) {
		            throw new RuntimeException(l.getClass().getName() + " is not implementing the Bootable interface.");
		        }
				((Bootable)l).onBoot();
			}
		}
	}

}
