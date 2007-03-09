/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.order;

import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.order.OrderProcessState;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProcessService {
    
    /**
     * Process an order based on the orderType
     * @param order
     * @return
     */
    public OrderProcessState processOrder(Order order);

}
