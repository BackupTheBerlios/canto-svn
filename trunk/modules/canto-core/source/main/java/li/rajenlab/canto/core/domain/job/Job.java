/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.job;

import li.rajenlab.canto.core.domain.salary.SalaryRange;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Job extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7081942977165075444L;
    
    private JobLevel jobLevel_;
    private String code_;
    private String name_;
    private String description_;
    private SalaryRange salaryRange_;

    /**
     * @return the jobLevel
     */
    public JobLevel getJobLevel() {
        return this.jobLevel_;
    }

    /**
     * @param jobLevel the jobLevel to set
     */
    public void setJobLevel(JobLevel jobLevel) {
        this.jobLevel_ = jobLevel;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description_;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description_ = description;
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
     * @return the salaryRange
     */
    public SalaryRange getSalaryRange() {
        return this.salaryRange_;
    }

    /**
     * @param salaryRange the salaryRange to set
     */
    public void setSalaryRange(SalaryRange salaryRange) {
        this.salaryRange_ = salaryRange;
    }
    
    
    

}
