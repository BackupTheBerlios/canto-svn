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

import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningResponse;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioningResponse implements ProvisioningResponse {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3771745993215350899L;

    private Order order_;

    /**
     * @return the order
     */
    public Order getOrder() {
        return this.order_;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order_ = order;
    }
    
    
}
