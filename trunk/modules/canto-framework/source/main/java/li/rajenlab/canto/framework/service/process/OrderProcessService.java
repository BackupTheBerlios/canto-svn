/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.process;

import li.rajenlab.canto.framework.domain.order.OrderProcessState;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProcessService {
    
    /**
     * provisionOrder  order
     * @param order
     * @return
     */
    public OrderProcessState scheduleProvisionOrder(String orderId, boolean immediateFlag);
    
 
    
    
}
