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

import li.rajenlab.canto.framework.dao.order.OrderDao;
import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningEngine;
import li.rajenlab.canto.framework.domain.provisioning.order.OrderProvisioningContext;
import li.rajenlab.canto.framework.domain.provisioning.order.OrderProvisioningContextFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioningServiceImpl implements OrderProvisioningService {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(OrderProvisioningServiceImpl.class);
    private OrderProvisioningEngineResolver orderProvisioningEngineResolver_;
    private OrderProvisioningContextFactory orderProvisioningContextFactory;
    private OrderDao orderDao_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.provisioning.order.OrderProvisioningService#provisioning(li.rajenlab.canto.framework.domain.order.Order)
     */
    public void provisioning(Order order) {
        
        if (order==null){
            throw new IllegalArgumentException("Order can not be null");
        }
        
        log.info("[START] Provisioning of order [" + order.getOrderId()+"]");
        
        log.info("Resolve ProvisioningEngine for Order [" + order.getOrderId() 
                                        + "] of Type ["+order.getOrderType()+"]");
        
        
        ProvisioningEngine engine = getOrderProvisioningEngineResolver().resolveProvisioningEngineForOrder(order.getOrderType());
        OrderProvisioningContext provContext = getOrderProvisioningContextFactory().createContext();
        provContext.getOrderProvisioningRequest().setOrder(order);
        
        log.info("Invoke ProvisioningEngine for Order [" + order.getOrderId() 
                + "] of Type ["+order.getOrderType()+"]");
        engine.doProvisioning(provContext);
        
        log.info("[DONE] Provisioning of order [" + order.getOrderId()+"]");
        
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    /**
     * @return the orderProvisioningEngineResolver
     */
    public OrderProvisioningEngineResolver getOrderProvisioningEngineResolver() {
        return this.orderProvisioningEngineResolver_;
    }

    /**
     * @param orderProvisioningEngineResolver the orderProvisioningEngineResolver to set
     */
    public void setOrderProvisioningEngineResolver(
            OrderProvisioningEngineResolver orderProvisioningEngineResolver) {
        this.orderProvisioningEngineResolver_ = orderProvisioningEngineResolver;
    }


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
     * @return the orderProvisioningContextFactory
     */
    public OrderProvisioningContextFactory getOrderProvisioningContextFactory() {
        return this.orderProvisioningContextFactory;
    }



    /**
     * @param orderProvisioningContextFactory the orderProvisioningContextFactory to set
     */
    public void setOrderProvisioningContextFactory(
            OrderProvisioningContextFactory orderProvisioningContextFactory) {
        this.orderProvisioningContextFactory = orderProvisioningContextFactory;
    }
  
    
}
