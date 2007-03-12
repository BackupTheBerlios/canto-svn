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

import li.rajenlab.canto.framework.domain.common.CantoProcessState;
import li.rajenlab.common.domain.process.ProcessTimer;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class PendingProvisioningState extends BaseProvisioningState {

    private int longRetryLimit_;
    private long shortRetryInterval_;
    private long longRetryInterval_;
    
    /**
     * @see li.rajenlab.common.service.process.state.State#getName()
     */
    public String getName() {
        return CantoProcessState.ORDER_PENDING_PROVISIONING.getValue();
    }

    /**
     * @see li.rajenlab.common.service.process.state.BaseState#onEntry()
     */
    @Override
    public void onEntry() {
        super.onEntry();
        

        
        // offset into future of the timer to be set.
        long timerDelta = 0;
        
        // the timer is set as a function of the retry count
        int retryCount = getProcessInstance().getIntegerVariable(CantoProcessState.VARIABLE_RETRIES.getValue());
        if ( retryCount == 0 ) {
            getProcessInstance().addIntegerVariable(CantoProcessState.VARIABLE_RETRIES.getValue(),0);
            // first time entering - schedule sync immediately
            timerDelta += 0;
        } else {
            log.debug("RetryCount : " + retryCount);
            if ( retryCount < getLongRetryLimit() ) {
                // short retry interval
                timerDelta += getShortRetryInterval();
            } else {
                // long retry interval
                timerDelta += getLongRetryInterval();
            }
        }
        
        log.debug("TimerDelta: " + timerDelta + " from retryCount: " + retryCount);
        
        getProcessInstance().setTimer( new ProcessTimer(System.currentTimeMillis()+timerDelta));

    }

    /**
     * @return Returns the longRetryInterval.
     */
    public long getLongRetryInterval() {
        return longRetryInterval_;
    }

    /**
     * @param longRetryInterval The longRetryInterval to set.
     */
    public void setLongRetryInterval(long longRetryInterval) {
        this.longRetryInterval_ = longRetryInterval;
    }

    /**
     * @return Returns the longRetryLimit.
     */
    public int getLongRetryLimit() {
        return longRetryLimit_;
    }

    /**
     * @param longRetryLimit The longRetryLimit to set.
     */
    public void setLongRetryLimit(int longRetryLimit) {
        this.longRetryLimit_ = longRetryLimit;
    }

    /**
     * @return Returns the shortRetryInterval.
     */
    public long getShortRetryInterval() {
        return shortRetryInterval_;
    }

    /**
     * @param shortRetryInterval The shortRetryInterval to set.
     */
    public void setShortRetryInterval(long shortRetryInterval) {
        this.shortRetryInterval_ = shortRetryInterval;
    }
    
}
