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

import li.rajenlab.canto.framework.domain.order.OrderType;
import li.rajenlab.canto.framework.domain.provisioning.order.OrderProvisioningEngine;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProvisioningEngineResolver {
    
    /**
     * Based on the OrderType, the provrisioning engine for the ordertype is returned
     * @param order
     * @return
     */
    public OrderProvisioningEngine resolveProvisioningEngineForOrder(OrderType orderType);

}