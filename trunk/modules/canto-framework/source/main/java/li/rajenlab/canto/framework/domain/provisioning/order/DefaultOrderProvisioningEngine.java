/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.provisioning.order;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Default implementation simply put the order receieved in the response
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DefaultOrderProvisioningEngine 
    implements OrderProvisioningEngine {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(DefaultOrderProvisioningEngine.class);

    /**
     * @see li.rajenlab.canto.framework.domain.provisioning.ProvisioningEngine#doProvisioning(java.lang.Object)
     */
    public void doProvisioning(OrderProvisioningContext context) {
        log.info("doProvisioning for order["+context.getOrderProvisioningRequest().getOrder()+"]");
        context.getOrderProvisioningResponse().setOrder(
                            context.getOrderProvisioningRequest().getOrder());
    }

    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

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
   

}
