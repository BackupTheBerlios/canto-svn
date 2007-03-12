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



package li.rajenlab.common.service.errorhandler;


import li.rajenlab.common.dao.errorhandler.ErrorEventDao;
import li.rajenlab.common.domain.errorhandler.ErrorData;
import li.rajenlab.common.domain.errorhandler.ErrorEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ErrorHandlerServiceImpl implements ErrorHandlerService {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------
    private ErrorEventDao errorEventDao_;

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ErrorHandlerServiceImpl.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    public void handleError(ErrorEvent event) {
        if (log.isDebugEnabled()) {
            log.debug("-> handleError(" + event + "]");
        }
        
        li.rajenlab.common.domain.errorhandler.ErrorEvent domainEvent =
            new li.rajenlab.common.domain.errorhandler.ErrorEvent();
        convert(event, domainEvent);
        getErrorEventDao().persist(domainEvent);
    }

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------
    protected void convert(ErrorEvent source,
            li.rajenlab.common.domain.errorhandler.ErrorEvent target) {
        
        target.setCategory(source.getCategory());
        target.setSubcategory(source.getSubcategory());
        target.setModule(source.getModule());
        target.setReference(source.getReference());
        target.setDetail(source.getDetail());
        target.setStacktrace(source.getStacktrace());
        target.setTimestamp(source.getTimestamp());
        
        for (ErrorData data : source.getData()) {
            target.addErrorData(data.getName(), data.getValue());
        }
        
        
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    /**
     * @return Returns the errorEventDao.
     */
    public ErrorEventDao getErrorEventDao() {
        return errorEventDao_;
    }

    /**
     * @param errorEventDao The errorEventDao to set.
     */
    public void setErrorEventDao(ErrorEventDao errorEventDao) {
        errorEventDao_ = errorEventDao;
    }

}
