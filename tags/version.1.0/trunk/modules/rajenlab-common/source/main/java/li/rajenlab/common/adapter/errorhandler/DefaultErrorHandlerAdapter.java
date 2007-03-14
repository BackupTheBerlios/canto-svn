/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.adapter.errorhandler;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;
import li.rajenlab.common.service.xml.oxm.Marshaller;
import li.rajenlab.common.service.xml.oxm.castor.CastorMarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DefaultErrorHandlerAdapter implements ErrorHandlerAdapter {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(DefaultErrorHandlerAdapter.class);

    private Marshaller marshaller_ = new CastorMarshaller();
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.common.adapter.errorhandler.ErrorHandlerAdapter#raiseError(li.rajenlab.common.domain.errorhandler.ErrorEvent)
     */
    public void raiseError(ErrorEvent error) {
        byte[] message = getMarshaller().marshal(error);
        log.error(message);
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    /**
     * @return the marshaller
     */
    public Marshaller getMarshaller() {
        return this.marshaller_;
    }

    /**
     * @param marshaller the marshaller to set
     */
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller_ = marshaller;
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    
    

}
