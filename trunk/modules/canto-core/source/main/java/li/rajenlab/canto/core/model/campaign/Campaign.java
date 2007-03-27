/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.campaign;

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Campaign extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3129544096672586013L;
    
    private String name_;
    private CampaignStatus status_;
    private CampaignType type_;
    private Date startDate_;
    private Date endDate_;
    private String currency_;
    private float budget_;
    private float expectedRevenue_;
    private float actualCosts_;
    private float expectedCosts_;
    private String objective_;
    private String description_;
    
    /**
     * @return the actualCosts
     */
    public float getActualCosts() {
        return this.actualCosts_;
    }
    /**
     * @param actualCosts the actualCosts to set
     */
    public void setActualCosts(float actualCosts) {
        this.actualCosts_ = actualCosts;
    }
    /**
     * @return the budget
     */
    public float getBudget() {
        return this.budget_;
    }
    /**
     * @param budget the budget to set
     */
    public void setBudget(float budget) {
        this.budget_ = budget;
    }
    /**
     * @return the currency
     */
    public String getCurrency() {
        return this.currency_;
    }
    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency_ = currency;
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
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate_;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate_ = endDate;
    }
    /**
     * @return the expectedCosts
     */
    public float getExpectedCosts() {
        return this.expectedCosts_;
    }
    /**
     * @param expectedCosts the expectedCosts to set
     */
    public void setExpectedCosts(float expectedCosts) {
        this.expectedCosts_ = expectedCosts;
    }
    /**
     * @return the expectedRevenue
     */
    public float getExpectedRevenue() {
        return this.expectedRevenue_;
    }
    /**
     * @param expectedRevenue the expectedRevenue to set
     */
    public void setExpectedRevenue(float expectedRevenue) {
        this.expectedRevenue_ = expectedRevenue;
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
     * @return the objective
     */
    public String getObjective() {
        return this.objective_;
    }
    /**
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.objective_ = objective;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate_;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate_ = startDate;
    }
    /**
     * @return the status
     */
    public CampaignStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(CampaignStatus status) {
        this.status_ = status;
    }
    /**
     * @return the type
     */
    public CampaignType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(CampaignType type) {
        this.type_ = type;
    }
    
    
}
