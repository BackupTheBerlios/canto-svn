/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.provisioning;

import li.rajenlab.canto.framework.domain.order.Order;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioning extends AbstractProvisioning {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3940669605857188059L;
    
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
