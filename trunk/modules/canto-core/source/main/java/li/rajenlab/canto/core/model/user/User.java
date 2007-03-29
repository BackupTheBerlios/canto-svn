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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.canto.core.model.SimpleIdBeanEntity;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="User")
@Table(name="USER")
public class User extends SimpleIdBeanEntity implements UserDetails {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 264291769954586859L;

    @Column(name="USERNAME")
    private String username;
    
    @Column(name="PASSWORD")
    private String password;
    
    
    @Column(name="STATUS")
    private UserStatus status;
    
    @Column(name = "CREDENTIALCHANGEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credentialChangeOnDate;
    
    @Column(name="CREDENTIALNONEXPIRED")
    private boolean credentialsNonExpired;
    
    @ManyToMany(mappedBy="id", fetch = FetchType.LAZY)
    @OrderBy
    @JoinTable(name="USERROLE", joinColumns = @JoinColumn(name = "USERID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "id"))
    private List<Role> roles;
    
    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return this.roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities() {
        if (getRoles()!=null){
            return roles.toArray(new GrantedAuthority[roles.size()]);
        }
        return new GrantedAuthority[0];
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getPassword()
     */
    public String getPassword() {
        return password;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#getUsername()
     */
    public String getUsername() {
        return username;
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
        return credentialsNonExpired;
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
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the status
     */
    public UserStatus getStatus() {
        return this.status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * @return the credentialChangeOnDate
     */
    public Date getCredentialChangeOnDate() {
        return this.credentialChangeOnDate;
    }

    /**
     * @param credentialChangeOnDate the credentialChangeOnDate to set
     */
    public void setCredentialChangeOnDate(Date credentialChangeOnDate) {
        this.credentialChangeOnDate = credentialChangeOnDate;
    }

     /**
     * @param credentialsNonExpired the credentialsNonExpired to set
     */
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    
    

}
