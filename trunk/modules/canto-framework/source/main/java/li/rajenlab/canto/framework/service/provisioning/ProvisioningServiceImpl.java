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

import li.rajenlab.canto.framework.dao.provisioning.OrderProvisioningDao;
import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningTemplate;
import li.rajenlab.canto.framework.service.uid.UIDService;
import li.rajenlab.canto.framework.service.uid.UIDType;
import li.rajenlab.common.dao.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProvisioningServiceImpl implements ProvisioningService {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ProvisioningServiceImpl.class);
    
    private ProvisioningTemplateResolver provisioningTemplateResolver_;
    private OrderProvisioningDao orderProvisioningDao_;
    private UIDService uidService_;
   
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    
    /**
     * @see li.rajenlab.canto.framework.service.provisioning.ProvisioningService#createOrderProvisioning(li.rajenlab.canto.framework.domain.order.Order, java.util.Date)
     */
    public OrderProvisioning createOrderProvisioning(Order order, Date startDate) {
        if (order == null){
            throw new IllegalArgumentException("Order can not be null");
        }
        
        // get template of the order prov based on the order type
        ProvisioningTemplate provTemplate = provisioningTemplateResolver_.resolveProvisiongTemplate(order.getOrderType());
        if (provTemplate == null){
            throw new IllegalArgumentException("ProvisioningTemplate can not be null");
        }
        
        OrderProvisioning orderProv = new OrderProvisioning();
        orderProv.setOrder(order);
        orderProv.setSteps(provTemplate.getSteps());
        orderProv.setStatus(ProvisioningStatus.WAIT_NEXT_PROVISIONING_STEP);
        orderProv.setStartDate(startDate);
        
        // generate the provid key
        orderProv.setProvisioningId(getUidService().generate(UIDType.PROVISIONING));
        
        // store it
        getOrderProvisioningDao().store(orderProv);
        
        log.info("For orderId["+order.getOrderId()+"], " +
                "orderProvisioning["+orderProv.getProvisioningId()+"] created");
        
        return orderProv;
    }
    
    /**
     * @see li.rajenlab.canto.framework.service.provisioning.ProvisioningService#getOrderProvisioningByUid(java.lang.String)
     */
    public OrderProvisioning getOrderProvisioningByUid(String uid) throws EntityNotFoundException {
        return getOrderProvisioningDao().load(uid);
    }
    
    
    /**
     * @see li.rajenlab.canto.framework.service.provisioning.ProvisioningService#executeNextOrderProvisioningStep(li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning)
     */
    public OrderProvisioning executeNextOrderProvisioningStep(OrderProvisioning ordeProv) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see li.rajenlab.canto.framework.service.provisioning.ProvisioningService#getOrderProvisioningByState(li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus)
     */
    public List<OrderProvisioning> getOrderProvisioningByState(ProvisioningStatus provState) {
        // TODO Auto-generated method stub
        return null;
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
     * @return the provisioningTemplateResolver
     */
    public ProvisioningTemplateResolver getProvisioningTemplateResolver() {
        return this.provisioningTemplateResolver_;
    }

    /**
     * @param provisioningTemplateResolver the provisioningTemplateResolver to set
     */
    public void setProvisioningTemplateResolver(
            ProvisioningTemplateResolver provisioningTemplateResolver) {
        this.provisioningTemplateResolver_ = provisioningTemplateResolver;
    }



    /**
     * @return the orderProvisioningDao
     */
    public OrderProvisioningDao getOrderProvisioningDao() {
        return this.orderProvisioningDao_;
    }



    /**
     * @param orderProvisioningDao the orderProvisioningDao to set
     */
    public void setOrderProvisioningDao(OrderProvisioningDao orderProvisioningDao) {
        this.orderProvisioningDao_ = orderProvisioningDao;
    }



    /**
     * @return the uidService
     */
    public UIDService getUidService() {
        return this.uidService_;
    }



    /**
     * @param uidService the uidService to set
     */
    public void setUidService(UIDService uidService) {
        this.uidService_ = uidService;
    }

}
