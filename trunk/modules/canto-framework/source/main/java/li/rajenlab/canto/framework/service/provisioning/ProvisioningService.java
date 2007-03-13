/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.provisioning;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus;
import li.rajenlab.common.dao.EntityNotFoundException;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProvisioningService {
    
    /**
     * Create a new provisioning object for an order
     * @param order
     * @return
     */
    public OrderProvisioning createOrderProvisioning(Order order, Date startDate);
    
    /**
     * 
     * @param uid
     * @return
     */
    public OrderProvisioning getOrderProvisioningByUid(String uid)
        throws EntityNotFoundException;

    /**
     * Retrieve order provisioning by state
     * @param provState
     * @return
     */
    public List<OrderProvisioning> getOrderProvisioningByState(ProvisioningStatus provState);
    
    public OrderProvisioning executeNextOrderProvisioningStep(OrderProvisioning ordeProv);
}
