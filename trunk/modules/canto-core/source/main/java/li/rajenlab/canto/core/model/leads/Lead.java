/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.leads;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.campaign.Campaign;
import li.rajenlab.canto.core.model.common.Address;

/**
 * Leads are early contacts in the sales process. 
 * After they have been evaluated and assessed, you can convert them into contacts, opportunities, 
 * and accounts
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Lead extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2389190673097736723L;
    
    private LeadSource leadSource_;
    private LeadStatus leadStatus_;
    private Campaign   campaign_;
    private String referedBy_;
    private String statusDescription_;
    private String leadDescription_;
    private String leadCompanyName_;
    private String leadTitle_;
    private String leadFirstName_;
    private String leadLastName_;
    private String leadOfficePhone_;
    private String leadMobilePhone_;
    private String leadOtherPhone_;
    private String leadFax_;
    private String leadEmail_;
    private String leadEmailSecond_;
    private Account account_;
    private boolean emailNotShared_; // the lead opted to not share their email address with you
    private boolean invalidEmail_; // If an email address is invalid
    // The lead’s name to the Do Not Call list. 
    // This is to ensure that the lead is not targeted during campaigns.
    private boolean doNotCall_; 
    private Address primaryAddress_;
    private Address otherAddress_;
    
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
     * @return the doNotCall
     */
    public boolean isDoNotCall() {
        return this.doNotCall_;
    }
    /**
     * @param doNotCall the doNotCall to set
     */
    public void setDoNotCall(boolean doNotCall) {
        this.doNotCall_ = doNotCall;
    }
    /**
     * @return the emailNotShared
     */
    public boolean isEmailNotShared() {
        return this.emailNotShared_;
    }
    /**
     * @param emailNotShared the emailNotShared to set
     */
    public void setEmailNotShared(boolean emailNotShared) {
        this.emailNotShared_ = emailNotShared;
    }
    /**
     * @return the invalidEmail
     */
    public boolean isInvalidEmail() {
        return this.invalidEmail_;
    }
    /**
     * @param invalidEmail the invalidEmail to set
     */
    public void setInvalidEmail(boolean invalidEmail) {
        this.invalidEmail_ = invalidEmail;
    }
    /**
     * @return the leadDescription
     */
    public String getLeadDescription() {
        return this.leadDescription_;
    }
    /**
     * @param leadDescription the leadDescription to set
     */
    public void setLeadDescription(String leadDescription) {
        this.leadDescription_ = leadDescription;
    }
    /**
     * @return the leadEmail
     */
    public String getLeadEmail() {
        return this.leadEmail_;
    }
    /**
     * @param leadEmail the leadEmail to set
     */
    public void setLeadEmail(String leadEmail) {
        this.leadEmail_ = leadEmail;
    }
    /**
     * @return the leadEmailSecond
     */
    public String getLeadEmailSecond() {
        return this.leadEmailSecond_;
    }
    /**
     * @param leadEmailSecond the leadEmailSecond to set
     */
    public void setLeadEmailSecond(String leadEmailSecond) {
        this.leadEmailSecond_ = leadEmailSecond;
    }
    /**
     * @return the leadFax
     */
    public String getLeadFax() {
        return this.leadFax_;
    }
    /**
     * @param leadFax the leadFax to set
     */
    public void setLeadFax(String leadFax) {
        this.leadFax_ = leadFax;
    }
    /**
     * @return the leadFirstName
     */
    public String getLeadFirstName() {
        return this.leadFirstName_;
    }
    /**
     * @param leadFirstName the leadFirstName to set
     */
    public void setLeadFirstName(String leadFirstName) {
        this.leadFirstName_ = leadFirstName;
    }
    /**
     * @return the leadLastName
     */
    public String getLeadLastName() {
        return this.leadLastName_;
    }
    /**
     * @param leadLastName the leadLastName to set
     */
    public void setLeadLastName(String leadLastName) {
        this.leadLastName_ = leadLastName;
    }
    /**
     * @return the leadMobilePhone
     */
    public String getLeadMobilePhone() {
        return this.leadMobilePhone_;
    }
    /**
     * @param leadMobilePhone the leadMobilePhone to set
     */
    public void setLeadMobilePhone(String leadMobilePhone) {
        this.leadMobilePhone_ = leadMobilePhone;
    }
    /**
     * @return the leadOfficePhone
     */
    public String getLeadOfficePhone() {
        return this.leadOfficePhone_;
    }
    /**
     * @param leadOfficePhone the leadOfficePhone to set
     */
    public void setLeadOfficePhone(String leadOfficePhone) {
        this.leadOfficePhone_ = leadOfficePhone;
    }
    /**
     * @return the leadOtherPhone
     */
    public String getLeadOtherPhone() {
        return this.leadOtherPhone_;
    }
    /**
     * @param leadOtherPhone the leadOtherPhone to set
     */
    public void setLeadOtherPhone(String leadOtherPhone) {
        this.leadOtherPhone_ = leadOtherPhone;
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
     * @return the leadStatus
     */
    public LeadStatus getLeadStatus() {
        return this.leadStatus_;
    }
    /**
     * @param leadStatus the leadStatus to set
     */
    public void setLeadStatus(LeadStatus leadStatus) {
        this.leadStatus_ = leadStatus;
    }
    /**
     * @return the leadTitle
     */
    public String getLeadTitle() {
        return this.leadTitle_;
    }
    /**
     * @param leadTitle the leadTitle to set
     */
    public void setLeadTitle(String leadTitle) {
        this.leadTitle_ = leadTitle;
    }
    /**
     * @return the otherAddress
     */
    public Address getOtherAddress() {
        return this.otherAddress_;
    }
    /**
     * @param otherAddress the otherAddress to set
     */
    public void setOtherAddress(Address otherAddress) {
        this.otherAddress_ = otherAddress;
    }
    /**
     * @return the primaryAddress
     */
    public Address getPrimaryAddress() {
        return this.primaryAddress_;
    }
    /**
     * @param primaryAddress the primaryAddress to set
     */
    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress_ = primaryAddress;
    }
    /**
     * @return the referedBy
     */
    public String getReferedBy() {
        return this.referedBy_;
    }
    /**
     * @param referedBy the referedBy to set
     */
    public void setReferedBy(String referedBy) {
        this.referedBy_ = referedBy;
    }
    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {
        return this.statusDescription_;
    }
    /**
     * @param statusDescription the statusDescription to set
     */
    public void setStatusDescription(String statusDescription) {
        this.statusDescription_ = statusDescription;
    }
    /**
     * @return the leadCompanyName
     */
    public String getLeadCompanyName() {
        return this.leadCompanyName_;
    }
    /**
     * @param leadCompanyName the leadCompanyName to set
     */
    public void setLeadCompanyName(String leadCompanyName) {
        this.leadCompanyName_ = leadCompanyName;
    }
    
    

}
