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

import java.util.Date;
import java.util.List;
import java.util.Vector;

import li.rajenlab.common.domain.AbstractEntity;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class User extends AbstractEntity implements UserDetails {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5243445093750649891L;
    
    private String username_;
    private String password_;
    private Date lastSuccessfulLoginTime_;
    private Date lastFailedLoginTime_;
    private int nrFailedLogins_;
    private UserType userType_;
    private UserStatus userStatus_;
    private List<AccessRights> accessRights_;
    private List<AccessRights> externalAccessRights_;
    
    /**
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities() {
        if(externalAccessRights_ != null && externalAccessRights_.size() > 0) {
            externalAccessRights_.addAll(accessRights_);
            return externalAccessRights_.toArray(new GrantedAuthority[externalAccessRights_.size()]);
        }
        return accessRights_.toArray(new GrantedAuthority[accessRights_.size()]);
    }
    
    public void addExternalAccessRights(AccessRights accessRights){
        if (externalAccessRights_ == null){
            externalAccessRights_ = new Vector<AccessRights>();
        }
        
        externalAccessRights_.add(accessRights);
    }
    
    public void addAccessRights(AccessRights accessRights){
        if (accessRights_ ==null){
            accessRights_ = new Vector<AccessRights>();
        }
        accessRights_.add(accessRights);
    }
    
    public void removeExternalAccessRights(AccessRights accessRights){
        if (externalAccessRights_ != null){
            externalAccessRights_.remove(accessRights);
        }
    }
    
    public void removeAccessRights(AccessRights accessRights){
        if (accessRights_ !=null){
            accessRights_.remove(accessRights);
        }
    
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getPassword()
     */
    public String getPassword() {
        return password_;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getUsername()
     */
    public String getUsername() {
        return username_;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isAccountNonExpired()
     */
    public boolean isAccountNonExpired() {
        return !UserStatus.DELETED.equals(getUserStatus());
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
     */
    public boolean isAccountNonLocked() {
        return !UserStatus.BLOCKED.equals(getUserStatus());
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isCredentialsNonExpired()
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isEnabled()
     */
    public boolean isEnabled() {
        return UserStatus.ACTIVE.equals(getUserStatus());
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password_ = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username_ = username;
    }

    
    /**
     * @return the userStatus
     */
    public UserStatus getUserStatus() {
        return this.userStatus_;
    }

    /**
     * @param userStatus the userStatus to set
     */
    public void setUserStatus(UserStatus userStatus) {
        this.userStatus_ = userStatus;
    }

    /**
     * @return the userType
     */
    public UserType getUserType() {
        return this.userType_;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(UserType userType) {
        this.userType_ = userType;
    }

    /**
     * @return the lastFailedLoginTime
     */
    public Date getLastFailedLoginTime() {
        return this.lastFailedLoginTime_;
    }

    /**
     * @param lastFailedLoginTime the lastFailedLoginTime to set
     */
    public void setLastFailedLoginTime(Date lastFailedLoginTime) {
        this.lastFailedLoginTime_ = lastFailedLoginTime;
    }

    /**
     * @return the lastSuccessfulLoginTime
     */
    public Date getLastSuccessfulLoginTime() {
        return this.lastSuccessfulLoginTime_;
    }

    /**
     * @param lastSuccessfulLoginTime the lastSuccessfulLoginTime to set
     */
    public void setLastSuccessfulLoginTime(Date lastSuccessfulLoginTime) {
        this.lastSuccessfulLoginTime_ = lastSuccessfulLoginTime;
    }

    /**
     * @return the nrFailedLogins
     */
    public int getNrFailedLogins() {
        return this.nrFailedLogins_;
    }

    /**
     * @param nrFailedLogins the nrFailedLogins to set
     */
    public void setNrFailedLogins(int nrFailedLogins) {
        this.nrFailedLogins_ = nrFailedLogins;
    }

    
    
}
