/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao;

import li.rajenlab.common.dao.user.UserDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface DaoFactory {
    
    public static final String REFBEAN_USER_DAO = "userDao";
    

    
    /**
     * Get UserDao instance
     * @return
     */
    public abstract UserDao getUserDao();
    

}
