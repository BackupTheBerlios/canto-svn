/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.employee;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum EmployeeStatus implements StringValuedEnum {
    
    READY_TO_START("READY_TO_START"),
    IN_PROBATION("IN_PROBATION"),
    NORMAL("NORMAL"),
    LEAVING("LEAVING"),
    LEFT("LEFT");

    private String status_;
    
    private EmployeeStatus(String status){
        this.status_ = status;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }
    
    

}
