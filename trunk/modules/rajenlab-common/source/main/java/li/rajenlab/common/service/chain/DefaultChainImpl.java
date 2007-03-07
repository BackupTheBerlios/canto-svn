/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.chain;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class DefaultChainImpl implements Chain {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------
    
    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    
    protected static Log log = LogFactory.getLog(DefaultChainImpl.class);
    
    private List handler_;

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    public DefaultChainImpl(List handler) {
        Assert.notNull(handler,"List of Handler can not be null");
        this.handler_ = handler;
    }
    
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    public void invoke(Context context) throws ChainException {
        for(int i = 0 ; i < handler_.size() ; i++) {
            Object handleObject = handler_.get(i);
            // test if the current handler is of type Handler
            if(!Handler.class.isAssignableFrom(handleObject.getClass())) {
                throw new ChainException("handler at position [" + i + "] is not of type Handler");
            }
            Handler handle = (Handler)handleObject;
            log.debug("invoking handler: " + handle.hashCode());
            handle.invoke(context);
            log.debug("handler returned: " + handle.hashCode());
        }
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
