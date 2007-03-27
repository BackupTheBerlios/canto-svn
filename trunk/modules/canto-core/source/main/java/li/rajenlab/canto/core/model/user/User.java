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

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="User")
@Table(name="USER")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id_;
    
    @Column(name="USERNAME")
    private String username_;
    private String password_;
    private UserStatus status_;
    private Date credentialChangeOnDate_;
    private boolean credentialsNonExpired_;
    private List<Role> roles_;
    
    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return this.roles_;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles_ = roles;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities() {
        if (getRoles()!=null){
            return roles_.toArray(new GrantedAuthority[roles_.size()]);
        }
        return new GrantedAuthority[0];
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
        return !UserStatus.DELETED.equals(getStatus());
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isAccountNonLocked()
     */
    public boolean isAccountNonLocked() {
        return !UserStatus.BLOCKED.equals(getStatus());
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isCredentialsNonExpired()
     */
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired_;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isEnabled()
     */
    public boolean isEnabled() {
        return UserStatus.ACTIVE.equals(getStatus());
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
     * @return the status
     */
    public UserStatus getStatus() {
        return this.status_;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(UserStatus status) {
        this.status_ = status;
    }

    /**
     * @return the credentialChangeOnDate
     */
    public Date getCredentialChangeOnDate() {
        return this.credentialChangeOnDate_;
    }

    /**
     * @param credentialChangeOnDate the credentialChangeOnDate to set
     */
    public void setCredentialChangeOnDate(Date credentialChangeOnDate) {
        this.credentialChangeOnDate_ = credentialChangeOnDate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id_;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
    }

    /**
     * @param credentialsNonExpired the credentialsNonExpired to set
     */
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired_ = credentialsNonExpired;
    }
    
    

}
