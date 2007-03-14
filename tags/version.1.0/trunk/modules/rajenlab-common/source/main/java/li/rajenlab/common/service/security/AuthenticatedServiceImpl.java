/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.security;

import li.rajenlab.common.dao.user.UserDao;
import li.rajenlab.common.domain.security.User;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AuthenticatedServiceImpl implements AuthenticatedService {

    private UserDao userDao_;
    
    /**
     * @see li.rajenlab.common.service.security.AuthenticatedService#getAuthentication()
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * @see li.rajenlab.common.service.security.AuthenticatedService#getUser()
     */
    public User getUser() {
        String username = getUsername();
        if(username == null) {
            return null;
        }
        return (User)getUserDao().loadUserByUsername(username);
    }

    /**
     * @see li.rajenlab.common.service.security.AuthenticatedService#getUsername()
     */
    public String getUsername() {
        Authentication authentication = getAuthentication();
        if(authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    /**
     * @see li.rajenlab.common.service.security.AuthenticatedService#userIsInRole(java.lang.String)
     */
    public boolean userIsInRole(String authority) {
        GrantedAuthority[] authorities = null;
        authorities = getAuthentication().getAuthorities();
        
        int i = 0;
        boolean roleFound = false;
        while (i < authorities.length && roleFound == false ) {
            if ( authorities[i].getAuthority().toUpperCase().equals(authority.toUpperCase()) ) {
                roleFound = true;
            }
            i++;
        }
        return roleFound;
    }

    /**
     * @return the userDao
     */
    public UserDao getUserDao() {
        return this.userDao_;
    }

    /**
     * @param userDao the userDao to set
     */
    public void setUserDao(UserDao userDao) {
        this.userDao_ = userDao;
    }

    
}
