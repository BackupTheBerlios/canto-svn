/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.account;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum AccountStatus implements StringValuedEnum {
    
    NEW("NEW"),
    ACTIVE("ACTIVE"),
    SUSPENDED("SUSPENDED"),
    BLOCKED("BLOCKED"),
    INACTIVE("INACTIVE");

    private String status_;
    
    private AccountStatus(String status){
        this.status_ = status;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }

}
