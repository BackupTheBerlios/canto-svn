/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.security;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public enum UserType implements StringValuedEnum {
    
    USER("user"),
    SYSTEM("system");
    
    private final String userTypeName_;
    
    private UserType(final String name){
        this.userTypeName_ = name;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return userTypeName_;
    }
    
    

}
