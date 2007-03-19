/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.booking;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum BookingStatus implements StringValuedEnum {
    
    NEW("NEW"),
    OFFER("OFFER"),
    READY_FOR_APPROVAL("READY_FOR_APPROVAL"),
    CANCELLED("CANCELLED"),
    BOOKED("BOOKED");

    private String status_;
    
    private BookingStatus(String status){
        this.status_ = status;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }

}
