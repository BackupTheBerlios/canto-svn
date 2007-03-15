/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.user;

import java.util.List;

import li.rajenlab.common.domain.security.User;

import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class UserDaoHibernateImpl 
    extends HibernateDaoSupport implements UserDao {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(UserDaoHibernateImpl.class);

    private Class userClass_ = User.class;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see org.acegisecurity.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    public UserDetails loadUserByUsername(String pUsername)
            throws UsernameNotFoundException, DataAccessException {
        DetachedCriteria criteria = DetachedCriteria.forClass(getUserClass());
        criteria.add( Restrictions.eq("username",pUsername).ignoreCase());
        List users = getHibernateTemplate().findByCriteria(criteria);
        
        if (users == null || users.size() < 1) {
            throw new UsernameNotFoundException("no User ["+pUsername+"] found");
        } 
        
        return (UserDetails)users.get(0);
        
     
    }
    
    
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    /**
     * @see li.rajenlab.common.dao.user.UserDao#persists(org.acegisecurity.userdetails.UserDetails)
     */
    public void persists(UserDetails user) {
        getHibernateTemplate().persist(user);
    }


    /**
     * @return the userClass
     */
    public Class getUserClass() {
        return this.userClass_;
    }

    /**
     * @param userClazz the userClazz to set
     */
    public void setUserClass(Class userClazz) {
        this.userClass_ = userClazz;
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

   

}
