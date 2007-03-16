/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.service;

import li.rajenlab.canto.core.dao.DaoFactory;
import li.rajenlab.common.service.guid.Guid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class AbstractServiceImpl {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected Log log = LogFactory.getLog(getClass());

    protected Guid guid_ = new Guid();
    
    private DaoFactory daoFactory_;
    
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    public AbstractServiceImpl(){
        
    }
    
    public AbstractServiceImpl(DaoFactory factory){
        Assert.notNull(factory,"DaoFactory can not be null");
        this.daoFactory_ = factory;
    }
     //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

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
     * @return the daoFactory
     */
    public DaoFactory getDaoFactory() {
        return this.daoFactory_;
    }

    /**
     * @param daoFactory the daoFactory to set
     */
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory_ = daoFactory;
    }
}
