/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.provisioning;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ProvisioningStatus implements StringValuedEnum {
    
    WAIT_NEXT_PROVISIONING_STEP("WAIT_NEXT_PROVISIONING_STEP"),
    IN_PROVISIONING_STEP("IN_PROVISIONING_STEP"),
    PROVISIONED("PROVISIONED");

    private String status_;
    
    private ProvisioningStatus(String status){
        this.status_ = status;
        
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return this.status_;
    }

}
