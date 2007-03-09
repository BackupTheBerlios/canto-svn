/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.order.exceptions;

import li.rajenlab.canto.framework.domain.order.OrderType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class NoProcessMethodFoundException extends Exception {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8377281394390741527L;
    
    private OrderType orderType_;
    
    public NoProcessMethodFoundException(OrderType orderType){
        super("NoProcessMethodFoundException");
        this.orderType_ = orderType;
    }
    
    public OrderType getOrderType(){
        return orderType_;
    }

    /**
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return super.getMessage() + orderType_!=null ? " orderType["+orderType_.toString() + "]" : "";
    }
    
    
    

}
