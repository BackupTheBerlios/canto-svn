/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.salary;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Salary implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6265249710971558518L;
    
    
    private float salary_;
    private boolean payableIn13Month_;
    
    
    /**
     * @return the payableIn13Month
     */
    public boolean isPayableIn13Month() {
        return this.payableIn13Month_;
    }
    /**
     * @param payableIn13Month the payableIn13Month to set
     */
    public void setPayableIn13Month(boolean payableIn13Month) {
        this.payableIn13Month_ = payableIn13Month;
    }
    /**
     * @return the salary
     */
    public float getSalary() {
        return this.salary_;
    }
    /**
     * @param salary the salary to set
     */
    public void setSalary(float salary) {
        this.salary_ = salary;
    }
    
    

}
