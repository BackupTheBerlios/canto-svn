/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.account;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.call.Call;
import li.rajenlab.canto.core.model.campaign.Campaign;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.common.Address;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.common.Industry;
import li.rajenlab.canto.core.model.document.Document;
import li.rajenlab.canto.core.model.email.Email;
import li.rajenlab.canto.core.model.meeting.Meeting;
import li.rajenlab.canto.core.model.notes.Notes;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;
import li.rajenlab.canto.core.model.product.Product;
import li.rajenlab.canto.core.model.project.Project;
import li.rajenlab.canto.core.model.task.Task;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="Account")
@Table(name="ACCOUNT")
public class Account extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1412380490817658383L;
   
    // Entity Field
    @Id
    @Column(name="ACCOUNT_ID", insertable = true, updatable = true)
    @GeneratedValue(strategy=GenerationType.TABLE)
    @TableGenerator(name="PK_GENERATOR", table = "PK_GENERATOR", pkColumnName = "PK", valueColumnName = "VALUE", pkColumnValue = "PK_VALUE")
    private String accountId_;
    
    @Column(name="ANNUAL_REVENUE")
    private float annualRevenue_;
    private Contact contact_;
    private Address billingAddress_;
    private Address legalAddress_;
    private String description_;
    private String email_;
    private String emailSecond_;
    private Industry industry_;
    private Account parent_;
    private String phone_;
    private String phoneAlternate_;
    private String fax_;
    private String website_;
    @ManyToOne
    @JoinColumn(name="accountType__ID", referencedColumnName = "ACCOUNT_TYPE_ID")
    private AccountType accountType_;
    private AccountStatus status_;
    
    
    // Relationshipts
    @ManyToMany
    @JoinTable(name="ACCOUNT_OPPORTUNITIES", joinColumns = @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID"))
    private List<Opportunity> opportunities_; // list of opportunities of the account
    private List<Case> cases_; // list of the case of the acccount
    private List<Task> tasks_; // list of taskf or the account
    private List<Notes> notes_; // notes on the account
    private List<Meeting> meetings_; // list of meetings for the account
    private List<Call> calls_; // list of calls for the account
    private List<Product> products_; // list of product that the account has
    private List<Project> projects_; // list of projects that the account has
    private List<Campaign> campaigns_; // list of campaings for the account
    private List<Email> emails_; // list of emails for the account
    private List<Document> documents_; // list of documents for the account (not link to a case, opportunigs...)
    
    
    /**
     * @return the annualRevenue
     */
    public float getAnnualRevenue() {
        return this.annualRevenue_;
    }
    /**
     * @param annualRevenue the annualRevenue to set
     */
    public void setAnnualRevenue(float annualRevenue) {
        this.annualRevenue_ = annualRevenue;
    }
    /**
     * @return the billingAddress
     */
    public Address getBillingAddress() {
        return this.billingAddress_;
    }
    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress_ = billingAddress;
    }
    /**
     * @return the calls
     */
    public List<Call> getCalls() {
        return this.calls_;
    }
    /**
     * @param calls the calls to set
     */
    public void setCalls(List<Call> calls) {
        this.calls_ = calls;
    }
    /**
     * @return the cases
     */
    public List<Case> getCases() {
        return this.cases_;
    }
    /**
     * @param cases the cases to set
     */
    public void setCases(List<Case> cases) {
        this.cases_ = cases;
    }
    /**
     * @return the contact
     */
    public Contact getContact() {
        return this.contact_;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact_ = contact;
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
     * @return the email
     */
    public String getEmail() {
        return this.email_;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email_ = email;
    }
    /**
     * @return the emailSecond
     */
    public String getEmailSecond() {
        return this.emailSecond_;
    }
    /**
     * @param emailSecond the emailSecond to set
     */
    public void setEmailSecond(String emailSecond) {
        this.emailSecond_ = emailSecond;
    }
    /**
     * @return the fax
     */
    public String getFax() {
        return this.fax_;
    }
    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax_ = fax;
    }
    /**
     * @return the industry
     */
    public Industry getIndustry() {
        return this.industry_;
    }
    /**
     * @param industry the industry to set
     */
    public void setIndustry(Industry industry) {
        this.industry_ = industry;
    }
    /**
     * @return the meetings
     */
    public List<Meeting> getMeetings() {
        return this.meetings_;
    }
    /**
     * @param meetings the meetings to set
     */
    public void setMeetings(List<Meeting> meetings) {
        this.meetings_ = meetings;
    }
   
    /**
     * @return the notes
     */
    public List<Notes> getNotes() {
        return this.notes_;
    }
    /**
     * @param notes the notes to set
     */
    public void setNotes(List<Notes> notes) {
        this.notes_ = notes;
    }
    /**
     * @return the opportunities
     */
    public List<Opportunity> getOpportunities() {
        return this.opportunities_;
    }
    /**
     * @param opportunities the opportunities to set
     */
    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities_ = opportunities;
    }
    /**
     * @return the parent
     */
    public Account getParent() {
        return this.parent_;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(Account parent) {
        this.parent_ = parent;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return this.phone_;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone_ = phone;
    }
    /**
     * @return the phoneAlternate
     */
    public String getPhoneAlternate() {
        return this.phoneAlternate_;
    }
    /**
     * @param phoneAlternate the phoneAlternate to set
     */
    public void setPhoneAlternate(String phoneAlternate) {
        this.phoneAlternate_ = phoneAlternate;
    }
    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return this.products_;
    }
    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products_ = products;
    }
    /**
     * @return the projects
     */
    public List<Project> getProjects() {
        return this.projects_;
    }
    /**
     * @param projects the projects to set
     */
    public void setProjects(List<Project> projects) {
        this.projects_ = projects;
    }
    /**
     * @return the tasks
     */
    public List<Task> getTasks() {
        return this.tasks_;
    }
    /**
     * @param tasks the tasks to set
     */
    public void setTasks(List<Task> tasks) {
        this.tasks_ = tasks;
    }
    /**
     * @return the website
     */
    public String getWebsite() {
        return this.website_;
    }
    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website_ = website;
    }
    /**
     * @return the accountType
     */
    public AccountType getAccountType() {
        return this.accountType_;
    }
    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(AccountType accountType) {
        this.accountType_ = accountType;
    }
    /**
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId_;
    }
    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId_ = accountId;
    }
    /**
     * @return the campaigns
     */
    public List<Campaign> getCampaigns() {
        return this.campaigns_;
    }
    /**
     * @param campaigns the campaigns to set
     */
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns_ = campaigns;
    }
    /**
     * @return the emails
     */
    public List<Email> getEmails() {
        return this.emails_;
    }
    /**
     * @param emails the emails to set
     */
    public void setEmails(List<Email> emails) {
        this.emails_ = emails;
    }
    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return this.documents_;
    }
    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents_ = documents;
    }
    /**
     * @return the legalAddress
     */
    public Address getLegalAddress() {
        return this.legalAddress_;
    }
    /**
     * @param legalAddress the legalAddress to set
     */
    public void setLegalAddress(Address legalAddress) {
        this.legalAddress_ = legalAddress;
    }
    /**
     * @return the status
     */
    public AccountStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(AccountStatus status) {
        this.status_ = status;
    }
   
    
    
    
    

}
