/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.common;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum CantoProcessState implements StringValuedEnum {
    
    INITIAL("INITIAL"),
    FINAL("FINAL"),
    ORDER_PENDING_PROVISIONING("ORDER_PENDING_PROVISIONING"),
    ORDER_PROVISIONED("ORDER_PROVISIONED"),
    VARIABLE_RETRIES("retries"),
    METHOD_PROVISION_ORDER("provisionOrder"),
    METHOD_SCHEDULE("schedule"),
    PROCESS_URL_PROVISION_ORDER("urn://orderProvisioningProcess");

    private String processState_;
    
    private CantoProcessState(String processState){
        this.processState_ = processState;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return processState_;
    }
    
    
   

}
