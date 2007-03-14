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

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SalaryRange extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7120617324298348400L;

    private String salaryRangeId_;
    private String name_;
    private float lowerBound_;
    private float upperBound_;
    
    /**
     * @return the lowerBound
     */
    public float getLowerBound() {
        return this.lowerBound_;
    }
    /**
     * @param lowerBound the lowerBound to set
     */
    public void setLowerBound(float lowerBound) {
        this.lowerBound_ = lowerBound;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the salaryRangeId
     */
    public String getSalaryRangeId() {
        return this.salaryRangeId_;
    }
    /**
     * @param salaryRangeId the salaryRangeId to set
     */
    public void setSalaryRangeId(String salaryRangeId) {
        this.salaryRangeId_ = salaryRangeId;
    }
    /**
     * @return the upperBound
     */
    public float getUpperBound() {
        return this.upperBound_;
    }
    /**
     * @param upperBound the upperBound to set
     */
    public void setUpperBound(float upperBound) {
        this.upperBound_ = upperBound;
    }
    
    
    
}
