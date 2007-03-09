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
    IN_PROVISIONING ("IN_PROVISIONING"),
    PROVISIONED("PROVISIONED"),
    FAILED("FAILED"),
    PARKED("PARKED"),
    CANCELLED("CANCELLED")
    ;

    
    private String orderStatus_;
    
    private OrderStatus(String orderStatus){
        this.orderStatus_ = orderStatus;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        // TODO Auto-generated method stub
        return null;
    }

}
