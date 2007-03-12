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

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderService {
    
    /**
     * Create an order
     * @param order
     * @param wsFlag
     * @return
     */
    public Order createOrder(Order order, boolean wsFlag);

}
