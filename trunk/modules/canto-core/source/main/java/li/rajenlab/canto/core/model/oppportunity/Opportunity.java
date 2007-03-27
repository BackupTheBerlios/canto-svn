/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.oppportunity;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.campaign.Campaign;
import li.rajenlab.canto.core.model.contact.Contact;
import li.rajenlab.canto.core.model.leads.Lead;
import li.rajenlab.canto.core.model.leads.LeadSource;
import li.rajenlab.canto.core.model.sales.SalesStep;

/**
 * Use the Opportunities module to create and manage sales opportunities for your organization
 * Every opportunity must be associated with an account. You can associate 
 * an opportunity with only one account but you can associate it with multiple leads and contacts
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Opportunity extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3360863813386467468L;
  
    private Account account_;
    private List<Lead> leads_;
    private List<Contact> contacts_;
    private String name_;
    private OpportunityType type_;
    private LeadSource leadSource_;
    private Campaign campaign_;
    private Date expectedCloseDate_;
    private String description_;
    private SalesStep salesStep_;
    private String probabiltyInPercent_; //if the Sales Stage value is Closed/Won, then the probability changes to 100%
  
    
    /**
     * @return the account
     */
    public Account getAccount() {
        return this.account_;
    }
    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account_ = account;
    }
    /**
     * @return the campaign
     */
    public Campaign getCampaign() {
        return this.campaign_;
    }
    /**
     * @param campaign the campaign to set
     */
    public void setCampaign(Campaign campaign) {
        this.campaign_ = campaign;
    }
    /**
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return this.contacts_;
    }
    /**
     * @param contacts the contacts to set
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts_ = contacts;
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
     * @return the expectedCloseDate
     */
    public Date getExpectedCloseDate() {
        return this.expectedCloseDate_;
    }
    /**
     * @param expectedCloseDate the expectedCloseDate to set
     */
    public void setExpectedCloseDate(Date expectedCloseDate) {
        this.expectedCloseDate_ = expectedCloseDate;
    }
    /**
     * @return the leads
     */
    public List<Lead> getLeads() {
        return this.leads_;
    }
    /**
     * @param leads the leads to set
     */
    public void setLeads(List<Lead> leads) {
        this.leads_ = leads;
    }
    /**
     * @return the leadSource
     */
    public LeadSource getLeadSource() {
        return this.leadSource_;
    }
    /**
     * @param leadSource the leadSource to set
     */
    public void setLeadSource(LeadSource leadSource) {
        this.leadSource_ = leadSource;
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
     * @return the probabiltyInPercent
     */
    public String getProbabiltyInPercent() {
        return this.probabiltyInPercent_;
    }
    /**
     * @param probabiltyInPercent the probabiltyInPercent to set
     */
    public void setProbabiltyInPercent(String probabiltyInPercent) {
        this.probabiltyInPercent_ = probabiltyInPercent;
    }
   
    /**
     * @return the salesStep
     */
    public SalesStep getSalesStep() {
        return this.salesStep_;
    }
    /**
     * @param salesStep the salesStep to set
     */
    public void setSalesStep(SalesStep salesStep) {
        this.salesStep_ = salesStep;
    }
    /**
     * @return the type
     */
    public OpportunityType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(OpportunityType type) {
        this.type_ = type;
    }
    
    
}
