/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.provisioning.order;

import li.rajenlab.canto.framework.domain.order.Order;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProvisioningService {
    
    
    /**
     * Provisiong an order
     * @param order
     */
    public void provisioning(Order order);

}
