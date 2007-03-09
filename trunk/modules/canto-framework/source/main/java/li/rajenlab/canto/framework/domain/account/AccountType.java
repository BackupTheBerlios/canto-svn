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
public enum AccountType implements StringValuedEnum {
    
    PRIVATE("PRIVATE"),
    BUSINESS("BUSINESS"),
    RESIDENTIAL("RESIDENTIAL"),
    SOHO("SOHO"),
    MASS_CORPORATE("MASS_CORPORATE");

    private String type_;
    
    private AccountType(String type){
        type_ = type;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return type_;
    }

}
