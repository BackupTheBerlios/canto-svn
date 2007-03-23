/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job.profile;

import java.io.Serializable;

import li.rajenlab.canto.core.model.job.Level;
import li.rajenlab.canto.core.model.job.Pensum;
import li.rajenlab.canto.core.model.job.SalaryBand;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobProfile implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2766353012023460919L;

    private String id_;
    
    private String titel_;
    private String description_;
    private String requirement_;
    private Pensum pensum_;
    
    private JobProfileCategory category_;
    private Level level_;
    private JobProfileStatus status_;
    private SalaryBand salaryBand_;
    
    /**
     * @return the status
     */
    public JobProfileStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(JobProfileStatus status) {
        this.status_ = status;
    }
    /**
     * @return the category
     */
    public JobProfileCategory getCategory() {
        return this.category_;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(JobProfileCategory category) {
        this.category_ = category;
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
     * @return the id
     */
    public String getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
    }
    /**
     * @return the level
     */
    public Level getLevel() {
        return this.level_;
    }
    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level_ = level;
    }
    /**
     * @return the pensum
     */
    public Pensum getPensum() {
        return this.pensum_;
    }
    /**
     * @param pensum the pensum to set
     */
    public void setPensum(Pensum pensum) {
        this.pensum_ = pensum;
    }
    /**
     * @return the requirement
     */
    public String getRequirement() {
        return this.requirement_;
    }
    /**
     * @param requirement the requirement to set
     */
    public void setRequirement(String requirement) {
        this.requirement_ = requirement;
    }
    /**
     * @return the titel
     */
    public String getTitel() {
        return this.titel_;
    }
    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
        this.titel_ = titel;
    }
    /**
     * @return the salaryBand
     */
    public SalaryBand getSalaryBand() {
        return this.salaryBand_;
    }
    /**
     * @param salaryBand the salaryBand to set
     */
    public void setSalaryBand(SalaryBand salaryBand) {
        this.salaryBand_ = salaryBand;
    }
    
    
    

}
