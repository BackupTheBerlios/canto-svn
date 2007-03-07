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
public enum UserStatus implements StringValuedEnum {
    
    
    NEW("new"), 
    ACTIVE("active"), 
    BLOCKED("blocked"),
    SUSPENDED("suspended"),
    DELETED("deleted");
    
    
    private String userStatus_;
    
    private UserStatus (String name){
        userStatus_ = name;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return userStatus_;
    }

    
    
    
}
