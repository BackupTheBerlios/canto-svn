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
import li.rajenlab.canto.framework.domain.order.OrderStatus;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.support.validation.ValidationException;

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
    public Order createOrder(Order order, boolean wsFlag)
        throws ValidationException;
    
    /**
     * Cancel an order
     * @param order
     * @param wsFlag
     * @return
     * @throws ValidationException
     */
    public Order cancelOrder(Order order, boolean wsFlag)
        throws ValidationException;
    
    /**
     * 
     * @param order
     * @return
     */
    public Order updateOrderStatus(String orderId, OrderStatus newStatus)
        throws EntityNotFoundException, InvalidOrderStatusTransitionException;

}
