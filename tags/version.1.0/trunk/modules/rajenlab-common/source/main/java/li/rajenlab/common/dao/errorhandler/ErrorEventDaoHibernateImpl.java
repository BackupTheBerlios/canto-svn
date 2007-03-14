/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:48 $
 * $LastChangedDate:2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/rajenlab-common/source/main/java/li/rajenlab/common/dao/BaseDao.java $
 ******************************************************************************/


package li.rajenlab.common.dao.errorhandler;

import java.io.Serializable;
import java.util.List;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ErrorEventDaoHibernateImpl extends HibernateDaoSupport implements
        ErrorEventDao {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(ErrorEventDaoHibernateImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    public void persist(ErrorEvent event) throws DataAccessException {
        getHibernateTemplate().persist(event);
    }
    
    /*
     * Test-only method. 
     */
    @SuppressWarnings("unchecked")
    public List<ErrorEvent> loadAll() throws DataAccessException {
        return getHibernateTemplate().loadAll(ErrorEvent.class);
    }

    /*
     * Test-only method. 
     */
    public ErrorEvent loadById(Serializable id) throws DataAccessException {
        return (ErrorEvent) getHibernateTemplate().load(ErrorEvent.class, id);
    }
    
    /*
     * Test-only method.
     */
    public void delete(ErrorEvent event) throws DataAccessException {
        getHibernateTemplate().delete(event);
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


}
