/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.user;

import org.acegisecurity.GrantedAuthority;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Role implements GrantedAuthority {

    private String authority_;
    
    /**
     * @see org.acegisecurity.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return authority_;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority_ = authority;
    }
    
    

}
