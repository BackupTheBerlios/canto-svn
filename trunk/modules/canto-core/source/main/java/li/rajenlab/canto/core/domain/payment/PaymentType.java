/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.payment;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum PaymentType implements StringValuedEnum {
    
    VOUCHER("VOUCHER"),
    BILL("BILL");

    String paymentType_;
    
    private PaymentType(String paymentType){
        this.paymentType_ = paymentType;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return paymentType_;
    }

}
