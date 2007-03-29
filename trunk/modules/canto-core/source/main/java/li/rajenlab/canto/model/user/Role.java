/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.acegisecurity.GrantedAuthority;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="ROLE")
public class Role implements GrantedAuthority {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5177179940501619837L;
    
    @Id
    @Column(name="ROLE_ID")
    private int roleId;
    
    @Column(name="ROLE",unique=true,nullable=false,length=100)
    private String name;
    

    /**
     * @see org.acegisecurity.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return getName();
    }


    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the roleId
     */
    public int getRoleId() {
        return this.roleId;
    }


    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    

}
