/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.process.orderprovisioning;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum OrderProvisioningStateType implements StringValuedEnum {
    
    WAIT_NEXT_PROV_STEP_SCHEDULER("WAIT_NEXT_PROV_STEP_SCHEDULER"),
    VARIABLE_PARAM_RETRY_COUNTER("VARIABLE_PARAM_RETRY_COUNTER");

    private String stateType_;
    
    private OrderProvisioningStateType(String stateType){
        this.stateType_ = stateType;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return stateType_;
    }

}
