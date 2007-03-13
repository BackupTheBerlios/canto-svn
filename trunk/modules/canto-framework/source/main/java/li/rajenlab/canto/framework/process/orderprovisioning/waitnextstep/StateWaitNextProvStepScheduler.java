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

import li.rajenlab.canto.framework.process.orderprovisioning.OrderProvisioningStateType;
import li.rajenlab.common.domain.process.ProcessTimer;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class StateWaitNextProvStepScheduler extends BaseStateWaitNextProvStep {

 
    private int pollingStepInMinutes_ = 1;
    
    /**
     * @see li.rajenlab.common.service.process.state.State#getName()
     */
    public String getName() {
        return OrderProvisioningStateType.WAIT_NEXT_PROV_STEP_SCHEDULER.getValue();
    }

    
    /**
     * 
     * @see li.rajenlab.common.service.process.state.BaseState#onEntry()
     */
    @Override
    public void onEntry() {
        super.onEntry();
        Calendar nextTimerTime = Calendar.getInstance();
        nextTimerTime.add(Calendar.MINUTE, getPollingStepInMinutes());
        log.info("next polling time: " + nextTimerTime);
        getProcessInstance().setTimer(new ProcessTimer(nextTimerTime.getTime()));
    }

   
    /**
     * 
     */
    @Override
    public void onTimer() {
        super.logTransitionMethod("onTimer");
        
    }
    
    /**
     * @return the pollingStepInMinutes
     */
    public int getPollingStepInMinutes() {
        return this.pollingStepInMinutes_;
    }


    /**
     * @param pollingStepInMinutes the pollingStepInMinutes to set
     */
    public void setPollingStepInMinutes(int pollingStepInMinutes) {
        this.pollingStepInMinutes_ = pollingStepInMinutes;
    }
  
    
}
