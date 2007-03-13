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

import java.util.Calendar;

import li.rajenlab.canto.framework.dao.provisioning.OrderProvisioningDao;
import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningAction;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningActionContext;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStep;
import li.rajenlab.canto.framework.service.process.OrderProvisioningProcessState;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.domain.process.ProcessTimer;
import li.rajenlab.common.service.process.state.BaseState;
import li.rajenlab.common.service.security.AuthenticatedService;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class PendingOrderProvStepState extends BaseState {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    private OrderProvisioningDao orderProvisioningDao_;
    private AuthenticatedService authenticatedService_;
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
        return OrderProvisioningProcessState.ORDER_PROVISIONING_STEP_PENDING.getValue();
    }
    
    @Override
    public void onEntry() {
        super.onEntry();
        
        // set immediate timer
        getProcessInstance().setTimer( new ProcessTimer(System.currentTimeMillis()));
    }
    
    public void onTimer() {
        log.info("onTimer");
        
        String uid  = getProcessInstance().getOid();
        
        try {
            OrderProvisioning orderProv = getOrderProvisioningDao().getOrderProvisioningByUid(uid);
            
            if (orderProv.getSteps()!=null && !orderProv.getSteps().isEmpty()
                    && orderProv.getNextStepIndex()< orderProv.getSteps().size()){
                
                ProvisioningStep step = orderProv.getSteps().get(orderProv.getNextStepIndex());
                String actionClassName = step.getProvisioningActionName();
                try {
                    
                    ProvisioningAction action = (ProvisioningAction) Class.forName(actionClassName).newInstance();
                    ProvisioningActionContext context = new ProvisioningActionContext();
                    context.setData(orderProv);
                    action.doAction(context);
                    
                    step.setExecuted(true);
                    step.setExecutionDate(Calendar.getInstance().getTime());
                    step.setExecutionDoneBy(getAuthenticatedService().getUsername());
                    
                    orderProv.setNextStepIndex(orderProv.getNextStepIndex()+1);
                    orderProv.setStatus(ProvisioningStatus.WAIT_NEXT_PROVISIONING_STEP);
                    
                } catch (IllegalAccessException iae){
                    // this should not happen
                    log.warn("For provisionOrderId["+uid+"], actionName["+actionClassName+"] can not be acessed,reason="
                            +iae.getMessage());
                } catch (ClassNotFoundException e){
                    // this should not happen
                    log.warn("For provisionOrderId["+uid+"], actionName["+actionClassName+"] can not be found,reason="
                            +e.getMessage());
                } catch (InstantiationException e){
                    // this should not happen
                    log.warn("For provisionOrderId["+uid+"], actionName["+actionClassName+"] can not be Instantiationed ,reason="
                            +e.getMessage());
                }
                
            } else {
                orderProv.setStatus(ProvisioningStatus.PROVISIONED);
            }
            
            getOrderProvisioningDao().store(orderProv);
            
           
        } catch ( EntityNotFoundException lnfe ) {
            log.error("OrderProvisioning for " + uid + " not found.", lnfe);
        } 
        
        // transition to Final State
        getProcessInstance().setStateName( new FinalState().getName() );
        
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
