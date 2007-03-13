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

import li.rajenlab.common.domain.security.User;

import org.acegisecurity.Authentication;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface AuthenticatedService {
    
    /**
     * @return the current users username
     */
    public String getUsername();
    
    /**
     * Checks if the current user has given authority (role name)
     * @param authority
     * @return
     */
    public boolean userIsInRole(String authority);
    
    /**
     * @return the current acegi @see Authentication object
     */
    public Authentication getAuthentication();
    
    /**
     * @return @see User object that is currently logged in
     */
    public User getUser();

}
