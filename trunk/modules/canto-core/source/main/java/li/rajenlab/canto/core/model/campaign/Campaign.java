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
import java.util.List;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.account.Account;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Campaign extends Entity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3129544096672586013L;
    private Date startDate_;
    private Date endDate_;
    private float budget_;
    private CampaignStatus status_;
    private float expectedCost_;
    private float actualCost_;
    private String objective_;
    private CampaignType campaignType_;
    private String trackerKey_;
    private String trackerText_;
    private String trackerCount_;
    private String referUrl_;
    
    
    private List<Account> account_;


    /**
     * @return the account
     */
    public List<Account> getAccount() {
        return this.account_;
    }


    /**
     * @param account the account to set
     */
    public void setAccount(List<Account> account) {
        this.account_ = account;
    }


    /**
     * @return the actualCost
     */
    public float getActualCost() {
        return this.actualCost_;
    }


    /**
     * @param actualCost the actualCost to set
     */
    public void setActualCost(float actualCost) {
        this.actualCost_ = actualCost;
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
     * @return the campaignType
     */
    public CampaignType getCampaignType() {
        return this.campaignType_;
    }


    /**
     * @param campaignType the campaignType to set
     */
    public void setCampaignType(CampaignType campaignType) {
        this.campaignType_ = campaignType;
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
     * @return the expectedCost
     */
    public float getExpectedCost() {
        return this.expectedCost_;
    }


    /**
     * @param expectedCost the expectedCost to set
     */
    public void setExpectedCost(float expectedCost) {
        this.expectedCost_ = expectedCost;
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
     * @return the referUrl
     */
    public String getReferUrl() {
        return this.referUrl_;
    }


    /**
     * @param referUrl the referUrl to set
     */
    public void setReferUrl(String referUrl) {
        this.referUrl_ = referUrl;
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
     * @return the trackerCount
     */
    public String getTrackerCount() {
        return this.trackerCount_;
    }


    /**
     * @param trackerCount the trackerCount to set
     */
    public void setTrackerCount(String trackerCount) {
        this.trackerCount_ = trackerCount;
    }


    /**
     * @return the trackerKey
     */
    public String getTrackerKey() {
        return this.trackerKey_;
    }


    /**
     * @param trackerKey the trackerKey to set
     */
    public void setTrackerKey(String trackerKey) {
        this.trackerKey_ = trackerKey;
    }


    /**
     * @return the trackerText
     */
    public String getTrackerText() {
        return this.trackerText_;
    }


    /**
     * @param trackerText the trackerText to set
     */
    public void setTrackerText(String trackerText) {
        this.trackerText_ = trackerText;
    }
    
    

}
