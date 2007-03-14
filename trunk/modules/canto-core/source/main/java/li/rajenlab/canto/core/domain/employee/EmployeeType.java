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
public enum EmployeeType implements StringValuedEnum {
    
    CONTRACTOR("CONTRACTOR"),
    INTERNAL("INTERNAL");

    private String employeeType_;
    
    private EmployeeType(String employeeType){
        this.employeeType_ = employeeType;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        // TODO Auto-generated method stub
        return null;
    }
    
    

}
