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

package li.rajenlab.common.process.errorhandler;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;
import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.EventListener;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.service.errorhandler.ErrorHandlerService;
import li.rajenlab.common.service.xml.oxm.Unmarshaller;
import li.rajenlab.common.service.xml.oxm.castor.CastorMarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class PersistingEventListener implements EventListener {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(PersistingEventListener.class);
    
    private ErrorHandlerService errorHandlerService_;
    
    private Unmarshaller unmarshaller = new CastorMarshaller(ErrorEvent.class);

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    public void onEvent(Event event) {
        if ( event == null ) {
            throw new RuntimeException("event is null");
        }
        
        Attachment requestAttachment = event.getAttachment(
                StandardEventProperties.REQUEST_ATTACHMENT_NAME);

        byte[] aqpayload = (byte[])requestAttachment.getContentHandlerObject();

        if ( aqpayload == null ) {
            throw new RuntimeException("event does not contain aq payload");
        }
        
        ErrorEvent error = (ErrorEvent) getUnmarshaller().unmarshal(aqpayload);
        getErrorHandlerService().handleError(error);

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
     * @return Returns the errorHandlerService.
     */
    public ErrorHandlerService getErrorHandlerService() {
        return errorHandlerService_;
    }

    /**
     * @param errorHandlerService The errorHandlerService to set.
     */
    public void setErrorHandlerService(ErrorHandlerService errorHandlerService) {
        errorHandlerService_ = errorHandlerService;
    }

    /**
     * @return Returns the unmarshaller.
     */
    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    /**
     * @param unmarshaller The unmarshaller to set.
     */
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }



}
