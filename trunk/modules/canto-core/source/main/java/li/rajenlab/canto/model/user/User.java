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

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="USER")
public class User implements UserDetails {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3003075024562221252L;
    
    @Column(name="PASSWORD",nullable=false,length=20)
    private String password;
    
    @Id
    @Column(name="USERNAME",length=50,updatable=false)
    private String username;
    
    
    @ManyToMany(fetch=FetchType.LAZY)
    @OrderBy
    @JoinTable(name="USER_ROLE", joinColumns = @JoinColumn(name = "user_USERNAME", referencedColumnName = "USERNAME"), inverseJoinColumns = @JoinColumn(name = "role_ROLE_ID", referencedColumnName = "ROLE_ID"))
    private List<Role> roles;
    
    
    @Column(name="STATUS",nullable=false)
    @Enumerated(value=EnumType.STRING)
    private UserStatus status;
    
    @Column(name="EMAIL",length=50) 
    private String email;
    
    

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
     * @see org.acegisecurity.userdetails.UserDetails#getAuthorities()
     */
    public GrantedAuthority[] getAuthorities() {
        if (roles==null){
            return new GrantedAuthority[0];
        }
        return roles.toArray(new GrantedAuthority[roles.size()]);
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
        return true;
    }

    /**
     * @see org.acegisecurity.userdetails.UserDetails#isEnabled()
     */
    public boolean isEnabled() {
        return UserStatus.ACTIVE.equals(getStatus())
                || UserStatus.NEW.equals(getStatus());
    }

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
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
}
