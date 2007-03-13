/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.process.orderprovisioning.waitnextstep;

import java.util.Calendar;
import java.util.List;

import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningStatus;
import li.rajenlab.canto.framework.service.provisioning.ProvisioningService;
import li.rajenlab.common.service.process.state.BaseState;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class BaseStateWaitNextProvStep extends BaseState {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected Log log = LogFactory
            .getLog(getClass());
    
    private ProvisioningService provisioningService_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * this onTimer method is used in all wait states due to the fact that both
     * wait states result in the same action.
     */
    public void onTimer() {
        super.logTransitionMethod("onTimer");
        
        try {
            List<OrderProvisioning> orderProvNextSteps = getProvisioningService().
                    getOrderProvisioningByState(ProvisioningStatus.WAIT_NEXT_PROVISIONING_STEP);
            
            if (orderProvNextSteps!=null && !orderProvNextSteps.isEmpty()){
                // has order
                log.info("Found ["+orderProvNextSteps.size()+"] orderProvisioning " +
                        "in status ["+ProvisioningStatus.WAIT_NEXT_PROVISIONING_STEP.getValue()+"], " +
                                "start to process them if required");
                for (OrderProvisioning orderProvisioning : orderProvNextSteps){
                    
                    boolean doNextStep = false;
                    if (orderProvisioning.getNextStepDate()==null){
                        doNextStep = true;
                    } else {
                        // if no nextstep date, process it, otherwise check the
                        // next step date and process only if the date is in the past
                        Calendar now = Calendar.getInstance();
                        Calendar nextStep = Calendar.getInstance();
                        nextStep.setTime(orderProvisioning.getNextStepDate());
                        if (nextStep.before(now)){
                            doNextStep = true;
                        }
                    }
                    
                    if (doNextStep){
                        getProvisioningService().
                            executeNextOrderProvisioningStep(orderProvisioning);
                    }
                    
                }
            }
            
        } catch (Exception e){
            log.error("Exception whilte getOrderProvisioningByState(), reason="+e.getMessage());
            // TODO: notify the errrorHandler?
        }
       
        getProcessInstance().setStateName(new StateWaitNextProvStepScheduler().getName());
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
  
    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------
    /**
     * @return the provisioningService
     */
    public ProvisioningService getProvisioningService() {
        return this.provisioningService_;
    }
    /**
     * @param provisioningService the provisioningService to set
     */
    public void setProvisioningService(ProvisioningService provisioningService) {
        this.provisioningService_ = provisioningService;
    }

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
   
}
