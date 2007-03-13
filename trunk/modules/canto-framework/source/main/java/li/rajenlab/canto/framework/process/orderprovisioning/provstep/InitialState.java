/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.process.orderprovisioning.provstep;

import li.rajenlab.canto.framework.dao.provisioning.OrderProvisioningDao;
import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus;
import li.rajenlab.canto.framework.service.process.OrderProvisioningProcessState;
import li.rajenlab.common.adapter.errorhandler.ErrorHandlerAdapter;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.domain.errorhandler.ErrorEvent;
import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.service.process.state.BaseState;
import li.rajenlab.common.support.ErrorEventHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class InitialState extends BaseState {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(InitialState.class);
    
    private OrderProvisioningDao orderProvisioningDao_;
    private ErrorHandlerAdapter errorHandlerAdapter_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.common.service.process.state.State#getName()
     */
    public String getName() {
        return OrderProvisioningProcessState.INITIAL.getValue();
    }
    
    public void processOrderProvisioningStep(){
        
        log.info("processOrderProvisioningStep");
        
        OrderProvisioningProcessState resultingState = null;
        
        
        String uid = getProcessInstance().getOid();
        boolean success = true;
    
        try {
            OrderProvisioning orderProv = getOrderProvisioningDao().getOrderProvisioningByUid(uid);
            orderProv.setStatus(ProvisioningStatus.IN_PROVISIONING_STEP);
        
            getOrderProvisioningDao().store(orderProv);
            
        } catch (EntityNotFoundException efe){
            log.error("ProcessOrderProvisioningStep failed due to OrderProvisioningNotFound " + uid);
            // there is no point repeating this synchronization!
            success = true;

            ErrorEvent errorEvent = ErrorEventHelper.createErrorEvent(
                   "OrderProvisioning","ProcessOrderProvisioningStep", 
                   "inconsistent data", uid );
            ErrorEventHelper.fillInStackTrace(errorEvent, efe);
            getErrorHandlerAdapter().raiseError(errorEvent);
        } catch (Exception e){
            log.error("ProcessOrderProvisioningStep failed due to general exception,reason= " + e.getMessage());
            // there is no point repeating this synchronization!
            success = false;

            ErrorEvent errorEvent = ErrorEventHelper.createErrorEvent(
                   "OrderProvisioning","ProcessOrderProvisioningStep", 
                   "general exception", uid );
            ErrorEventHelper.fillInStackTrace(errorEvent, e);
            getErrorHandlerAdapter().raiseError(errorEvent);
        }
        
        if ( success ) {
            resultingState = OrderProvisioningProcessState.ORDER_PROVISIONING_STEP_EXECUTED;
            getProcessInstance().setStateName(new FinalState().getName());
        } else {
            resultingState = OrderProvisioningProcessState.ORDER_PROVISIONING_STEP_PENDING;
            getProcessInstance().setStateName(new PendingOrderProvStepState().getName() );
        }
        
        // give a sync response back to the calling layer, by attaching it to the event
        Attachment resAttachment = new Attachment( new ObjectContentHandler(resultingState));
        getEvent().addAttachment( StandardEventProperties.RESPONSE_ATTACHMENT_NAME, resAttachment);
        
        //  transition to PendingNotification State
        getProcessInstance().setStateName(new PendingOrderProvStepState().getName() );
        
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
    

}
