/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.process.order.provisioning;

import li.rajenlab.canto.framework.CantoConsts;
import li.rajenlab.canto.framework.dao.order.OrderDao;
import li.rajenlab.canto.framework.domain.common.CantoProcessState;
import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.service.provisioning.order.OrderProvisioningService;
import li.rajenlab.common.adapter.errorhandler.ErrorHandlerAdapter;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.domain.errorhandler.ErrorEvent;
import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.service.process.state.BaseState;
import li.rajenlab.common.support.ErrorEventHelper;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class BaseProvisioningState extends BaseState {
    
    
    private OrderDao orderDao_;
    private ErrorHandlerAdapter errorHandlerAdapter_;
    private OrderProvisioningService orderProvisioningService_;

    
    public void provisionOrder(){
        log.info("provisionOrder");
        
        CantoProcessState resultState = null;
        boolean success = true;
        String uid = getProcessInstance().getOid();
        
        try {
            
            Order order = getOrderDao().load(uid);
            
            getOrderProvisioningService().provisioning(order);
            
        } catch (EntityNotFoundException e){
            log.error("Provision failed due to OrderNotFound " + uid);
            success = true;

            ErrorEvent errorEvent = ErrorEventHelper.createErrorEvent(CantoConsts.ORDER_MODULE_NAME,
                        "ProvisionOrder", "inconsistent data", uid );
            ErrorEventHelper.fillInStackTrace(errorEvent, e);

            getErrorHandlerAdapter().raiseError(errorEvent);

        } catch ( Exception e ) {
            log.warn("provisionOrder failed in OrderProvisioningAdapter.", e);
            success = false;
            
            ErrorEvent errorEvent = ErrorEventHelper.createErrorEvent(
                    CantoConsts.ORDER_MODULE_NAME,"OrderProvisioningAdapter", "sync", uid );
            ErrorEventHelper.fillInStackTrace(errorEvent, e);
            getErrorHandlerAdapter().raiseError(errorEvent);
        }
        
        if ( success ) {
            setProcessRetryCount(0);
            resultState = CantoProcessState.ORDER_PROVISIONED;
            getProcessInstance().setStateName( new FinalState().getName() );
        } else {
            setProcessRetryCount( getProcessRetryCount() + 1 );
            resultState = CantoProcessState.ORDER_PENDING_PROVISIONING;
            getProcessInstance().setStateName( new PendingProvisioningState().getName() );
        }
        
        // give a sync response back to the calling layer, by attaching it to the event
        Attachment resAttachment = new Attachment( new ObjectContentHandler(resultState));
        getEvent().addAttachment( StandardEventProperties.RESPONSE_ATTACHMENT_NAME, resAttachment);


        
    }

    public void schedule() {
        log.info("schedule");
        
        // give a sync response back to the calling layer, by attaching it to the event
        Attachment resAttachment = new Attachment( new ObjectContentHandler(CantoProcessState.ORDER_PENDING_PROVISIONING));
        getEvent().addAttachment( StandardEventProperties.RESPONSE_ATTACHMENT_NAME, resAttachment);
        
        // transition to PendingSync state
        getProcessInstance().setStateName( new PendingProvisioningState().getName() );
    }

    public void onTimer() {
        log.info("onTimer -> sync()");
        provisionOrder();
    }

    protected int getProcessRetryCount() {
        return getProcessInstance().getIntegerVariable(CantoProcessState.VARIABLE_RETRIES.getValue());
    }
    
    protected void setProcessRetryCount( int retryCount ) {
        getProcessInstance().addIntegerVariable(CantoProcessState.VARIABLE_RETRIES.getValue(), retryCount);
    }
    
    /**
     * @return the errorHandlerAdapter
     */
    public ErrorHandlerAdapter getErrorHandlerAdapter() {
        return this.errorHandlerAdapter_;
    }


    /**
     * @param errorHandlerAdapter the errorHandlerAdapter to set
     */
    public void setErrorHandlerAdapter(ErrorHandlerAdapter errorHandlerAdapter) {
        this.errorHandlerAdapter_ = errorHandlerAdapter;
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
     * @return the provisioningService
     */
    public OrderProvisioningService getOrderProvisioningService() {
        return this.orderProvisioningService_;
    }

    /**
     * @param provisioningService the provisioningService to set
     */
    public void setOrderProvisioningService(OrderProvisioningService provisioningService) {
        this.orderProvisioningService_ = provisioningService;
    }




}
