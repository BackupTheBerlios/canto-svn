/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.process;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum OrderProvisioningProcessState implements StringValuedEnum {
    
    INITIAL("INITIAL"),
    ORDER_PROVISIONING_STEP_PENDING("ORDER_PROVISIONING_STEP_PENDING"),
    ORDER_PROVISIONING_STEP_EXECUTED("ORDER_PROVISIONING_STEP_EXECUTED"),
    FINAL("FINAL"),
    PROCESS_URL_ORDER_PROVISIONING_STEP("urn://OrderProvisioningStepProcess"),
    METHOD_PROCESS_ORDER_PROVISIONING_STEP("processOrderProvisioningStep"),
    VARIABLE_RETRIES("retries");
    
    private String processState_;
    
    private OrderProvisioningProcessState(String processState){
        this.processState_ = processState;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return processState_;
    }

}
