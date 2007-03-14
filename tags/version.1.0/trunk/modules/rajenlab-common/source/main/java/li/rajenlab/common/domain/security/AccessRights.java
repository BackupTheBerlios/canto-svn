/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.security;

import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.module.Module;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AccessRights extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -47051225143907597L;
    
    
    private Role role_;
    private Module module_;
    
    /**
     * @return the module
     */
    public Module getModule() {
        return this.module_;
    }
    /**
     * @param module the module to set
     */
    public void setModule(Module module) {
        this.module_ = module;
    }
    /**
     * @return the role
     */
    public Role getRole() {
        return this.role_;
    }
    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role_ = role;
    }
    
    
    
    

}
