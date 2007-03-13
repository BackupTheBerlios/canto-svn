/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum OrderStatus implements StringValuedEnum {
    
    NEW ("NEW"),
    PENDING("PENDING"),
    CLOSED("CLOSED"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED"),
    IN_PROGRESS("IN_PROGRESS");

    
    private String orderStatus_;
    
    private OrderStatus(String orderStatus){
        this.orderStatus_ = orderStatus;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return orderStatus_;
    }

}
