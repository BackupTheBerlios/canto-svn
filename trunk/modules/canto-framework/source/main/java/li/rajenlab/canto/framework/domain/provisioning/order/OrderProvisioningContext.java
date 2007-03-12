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

import li.rajenlab.canto.framework.domain.provisioning.ProvisioningContext;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningRequest;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioningContext implements ProvisioningContext {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5455074109066213326L;

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(OrderProvisioningContext.class);

    private OrderProvisioningRequest orderProvisioningRequest_;
    private OrderProvisioningResponse orderProvisioningResponse_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    public OrderProvisioningContext(){
        orderProvisioningRequest_ = new OrderProvisioningRequest();
        orderProvisioningResponse_ = new OrderProvisioningResponse();
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
     * @see li.rajenlab.canto.framework.domain.provisioning.ProvisioningContext#getRequest()
     */
    public ProvisioningRequest getRequest() {
        return getOrderProvisioningRequest();
    }

    /**
     * @see li.rajenlab.canto.framework.domain.provisioning.ProvisioningContext#getResponse()
     */
    public ProvisioningResponse getResponse() {
        return getOrderProvisioningResponse();
    }

    /**
     * @return the orderProvisioningRequest
     */
    public OrderProvisioningRequest getOrderProvisioningRequest() {
        return this.orderProvisioningRequest_;
    }

    /**
     * @return the orderProvisioningResponse
     */
    public OrderProvisioningResponse getOrderProvisioningResponse() {
        return this.orderProvisioningResponse_;
    }

   
}
