/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.subscription;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum SubscriptionStatus implements StringValuedEnum {
    
    ACTIVE("ACTIVE"),
    SUSPENDEND("SUSPENDED"),
    CEASED("CEASED");

    private String status_;
    
    private SubscriptionStatus(String status){
        this.status_ = status;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }
    
    

}
