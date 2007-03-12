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
import li.rajenlab.canto.framework.service.process.OrderProcessService;
import li.rajenlab.canto.framework.service.uid.OrderUIDService;

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
    private OrderProcessService orderProcessService_;
    private OrderUIDService orderUIDService_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.order.OrderService#createOrder(li.rajenlab.canto.framework.domain.order.Order, boolean)
     */
    public Order createOrder(Order order, boolean wsFlag) {
        if( order == null ) {
            throwMissing("create", "order");
        }
        if ( order.getOrderId() != null ) {
            throw new RuntimeException("order must be a detached entity!");
        }
        
        // do the validation
        
        // generate the order id
        order.setOrderId(getOrderUIDService().generate());
        
        Order newOrder = new Order();
        order.copyTo(newOrder);
        
        // persists the order
        getOrderDao().store(newOrder);
        
        // do the provisioning (if not ws then immediately execute!)
        getOrderProcessService().scheduleProvisionOrder(newOrder.getOrderId(), !wsFlag);
        
        return order;
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
     * @return the orderProcessService
     */
    public OrderProcessService getOrderProcessService() {
        return this.orderProcessService_;
    }

    /**
     * @param orderProcessService the orderProcessService to set
     */
    public void setOrderProcessService(OrderProcessService orderProcessService) {
        this.orderProcessService_ = orderProcessService;
    }

    /**
     * @return the orderUIDService
     */
    public OrderUIDService getOrderUIDService() {
        return this.orderUIDService_;
    }

    /**
     * @param orderUIDService the orderUIDService to set
     */
    public void setOrderUIDService(OrderUIDService orderUIDService) {
        this.orderUIDService_ = orderUIDService;
    }

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

   

}
