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

import li.rajenlab.canto.framework.dao.order.OrderDao;
import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.order.OrderNote;
import li.rajenlab.canto.framework.domain.order.OrderStatus;
import li.rajenlab.canto.framework.service.uid.UIDService;
import li.rajenlab.canto.framework.service.uid.UIDType;
import li.rajenlab.canto.framework.support.OrderValidator;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.service.security.AuthenticatedService;
import li.rajenlab.common.support.validation.ValidationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderServiceImpl implements OrderService {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(OrderServiceImpl.class);
    private OrderDao orderDao_;
    private UIDService orderUIDService_;
    private OrderValidator orderValidator_;
    private AuthenticatedService authenticatedService_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.order.OrderService#createOrder(li.rajenlab.canto.framework.domain.order.Order, boolean)
     */
    public Order createOrder(Order order, boolean wsFlag)
        throws ValidationException {
        if( order == null ) {
            throwMissing("create", "order");
        }
        if ( order.getOrderId() != null ) {
            throw new RuntimeException("order must be a detached entity!");
        }
        
        // do the validation
        getOrderValidator().validate(order);
        
        // generate the order id
        order.setOrderId(getOrderUIDService().generate(UIDType.ORDER));
        order.setOrderStatus(OrderStatus.NEW);
        
        Order newOrder = new Order();
        order.copyTo(newOrder);
        
        // persists the order
        getOrderDao().store(newOrder);
        
        // start the provisioning...
        
        
        return order;
    }
    
    
    
    
    /**
     * @see li.rajenlab.canto.framework.service.order.OrderService#cancelOrder(li.rajenlab.canto.framework.domain.order.Order, boolean)
     */
    public Order cancelOrder(Order order, boolean wsFlag) throws ValidationException {
        // TODO Auto-generated method stub
        return null;
    }




    /**
     * @see li.rajenlab.canto.framework.service.order.OrderService#updateOrderStatus(java.lang.String, li.rajenlab.canto.framework.domain.order.OrderStatus)
     */
    public Order updateOrderStatus(String orderId, OrderStatus newStatus) 
        throws EntityNotFoundException, InvalidOrderStatusTransitionException {
        
        if( orderId == null ) {
            throwMissing("updateOrderStatus", "orderId");
        }
        
        Order currentOrder = getOrderDao().load(orderId);
        OrderStatus currentStatus = currentOrder.getOrderStatus();
        
        // not transition state allowed in cancelled or close mode
        if (OrderStatus.CANCELLED.equals(currentStatus) || 
                OrderStatus.CLOSED.equals(currentStatus)){
            throw new InvalidOrderStatusTransitionException("currentStatus ["+currentStatus+"] " +
                    "does not allow to update order status to ["+newStatus+"]");
        }
        
        // check the validation of the transition
        // NEW -> PENDING or CANCELLED or CLOSED or FAILED OR IN_PROGRESS
        // PENDING -> CANCELLED or IN_PROGRESS
        // FAILED -> CANCELLED or CLOSED OR IN_PROGRESS
        // IN_PROGRESS -> CANCELLED or CLOSED or FAILED
        boolean allowStatusTransition = false;
        if (OrderStatus.NEW.equals(currentStatus) && 
                (OrderStatus.PENDING.equals(newStatus) 
                        || OrderStatus.CANCELLED.equals(newStatus)
                        || OrderStatus.CLOSED.equals(newStatus)
                        || OrderStatus.FAILED.equals(newStatus)
                        || OrderStatus.IN_PROGRESS.equals(newStatus))){
            allowStatusTransition = true;
        } else if (OrderStatus.PENDING.equals(currentStatus) && 
                    (OrderStatus.CANCELLED.equals(newStatus)
                            || OrderStatus.IN_PROGRESS.equals(newStatus))){
            allowStatusTransition = true;
        } else if (OrderStatus.FAILED.equals(currentStatus) && 
                     (OrderStatus.CANCELLED.equals(newStatus)
                             || OrderStatus.CLOSED.equals(newStatus)
                             || OrderStatus.IN_PROGRESS.equals(newStatus))){
            allowStatusTransition = true;
        } else if (OrderStatus.IN_PROGRESS.equals(currentStatus) && 
                       (OrderStatus.CANCELLED.equals(newStatus)
                               || OrderStatus.CLOSED.equals(newStatus)
                               || OrderStatus.FAILED.equals(newStatus))){
            allowStatusTransition = true;
        }
        
        if (!allowStatusTransition){
            throw new InvalidOrderStatusTransitionException("currentStatus ["+currentStatus+"] " +
                    "does not allow the transition to state ["+newStatus+"]");
        }
        
        currentOrder.setOrderStatus(newStatus);
        OrderNote orderNote = new OrderNote();
        orderNote.setUser(getAuthenticatedService().getUser());
        orderNote.setOrder(currentOrder);
        orderNote.setMessage("update Order Status from ["+currentStatus.getValue()
                                            +"] to ["+newStatus.getValue()+"]");
        currentOrder.addOrderNote(orderNote);
        
        getOrderDao().store(currentOrder);
        
        log.info("Update Order status for orderId["+currentOrder.getOrderId()+"] " +
                "oldStatus["+currentStatus.getValue()+"], newStatus["+newStatus.getValue()+"]");
        
        return currentOrder;
    }




    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
    protected void throwMissing( String method, String parameterName ) {
        throw new RuntimeException("Missing parameter "+ parameterName + " in method " + method);
    }
    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    /**
     * @return the orderDao
     */
    public OrderDao getOrderDao() {
        return this.orderDao_;
    }

    /**
     * @param orderDao the orderDao to set
     */
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao_ = orderDao;
    }

       /**
     * @return the orderUIDService
     */
    public UIDService getOrderUIDService() {
        return this.orderUIDService_;
    }

    /**
     * @param orderUIDService the orderUIDService to set
     */
    public void setOrderUIDService(UIDService orderUIDService) {
        this.orderUIDService_ = orderUIDService;
    }

    /**
     * @return the orderValidator
     */
    public OrderValidator getOrderValidator() {
        return this.orderValidator_;
    }

    /**
     * @param orderValidator the orderValidator to set
     */
    public void setOrderValidator(OrderValidator orderValidator) {
        this.orderValidator_ = orderValidator;
    }




    /**
     * @return the authenticatedService
     */
    public AuthenticatedService getAuthenticatedService() {
        return this.authenticatedService_;
    }




    /**
     * @param authenticatedService the authenticatedService to set
     */
    public void setAuthenticatedService(AuthenticatedService authenticatedService) {
        this.authenticatedService_ = authenticatedService;
    }

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

   

}
