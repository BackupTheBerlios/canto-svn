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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DaoFactoryImpl implements DaoFactory, ApplicationContextAware {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(DaoFactoryImpl.class);
    private ApplicationContext context_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
   
    /**
     * @see li.rajenlab.canto.core.dao.DaoFactory#getUserDao()
     */
    public UserDao getUserDao() {
        return (UserDao)getApplicationContext().getBean(REFBEAN_USER_DAO);
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
  

    /**
     * @return the context
     */
    public ApplicationContext getApplicationContext() {
        return this.context_;
    }

    /**
     * @param context the context to set
     */
    public void setApplicationContext(ApplicationContext context) {
        this.context_ = context;
    }

}
