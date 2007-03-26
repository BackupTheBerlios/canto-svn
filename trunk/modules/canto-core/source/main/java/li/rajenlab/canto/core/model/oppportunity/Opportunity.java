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
import li.rajenlab.canto.core.model.call.Call;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.meeting.Meeting;
import li.rajenlab.canto.core.model.notes.Notes;
import li.rajenlab.canto.core.model.product.Product;
import li.rajenlab.canto.core.model.project.Project;
import li.rajenlab.canto.core.model.sales.SalesStep;
import li.rajenlab.canto.core.model.task.Task;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.JoinTable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="OPPORTUNITY")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Opportunity extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3360863813386467468L;
    private OpportunityType opportunityType_;
    @Column(name="AMOUNT")
    private float amount_;
    @Column(name="CURRENCY")
    private String currency_;
    @Column(name="DATE_CLOSED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateClosed_;
    @ManyToOne
    @JoinColumn(name="NEXT_STEP_ID", referencedColumnName = "ID")
    private SalesStep nextStep_;
    @Column(name="PROB_IN_PRECENT")
    private float  probabilityInPercent_;
    @Column(name="ACCOUNT")
    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account_;
    
    @ManyToMany
    @JoinColumn(name="products__null")
    @OrderBy
    @JoinTable(joinColumns=@JoinColumn(name="OPPORTUNITY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"), name = "OPPORTUNITY_PRODUCTS")
    private List<Product> products_;
    @ManyToOne
    @JoinColumn(name="PROJECT_ID)", referencedColumnName = "ID")
    private Project project_;
    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name="OPPORTUNITY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "MEETING_ID", referencedColumnName = "ID"), name = "OPPORTUNTY_MEETINGS")
    private List<Meeting> meetings_;
    @ManyToMany
    @JoinTable(name="OPPORTUNITY_CALLS", joinColumns = @JoinColumn(name = "OPPORTUNITY_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "CALL_ID", referencedColumnName = "ID"))
    private List<Call> calls_;
    @ManyToMany
    private List<Task> tasks_;
    @ManyToOne
    @JoinColumn(name="CONTACT_ID", referencedColumnName = "ID")
    private Contact contact_;
    @ManyToMany
    @JoinTable(name="OPPORTUNITY_NOTES")
    private List<Notes> notes_;
    
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
     * @return the amount
     */
    public float getAmount() {
        return this.amount_;
    }
    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount_ = amount;
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
     * @return the dateClosed
     */
    public Date getDateClosed() {
        return this.dateClosed_;
    }
    /**
     * @param dateClosed the dateClosed to set
     */
    public void setDateClosed(Date dateClosed) {
        this.dateClosed_ = dateClosed;
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
     * @return the nextStep
     */
    public SalesStep getNextStep() {
        return this.nextStep_;
    }
    /**
     * @param nextStep the nextStep to set
     */
    public void setNextStep(SalesStep nextStep) {
        this.nextStep_ = nextStep;
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
     * @return the opportunityType
     */
    public OpportunityType getOpportunityType() {
        return this.opportunityType_;
    }
    /**
     * @param opportunityType the opportunityType to set
     */
    public void setOpportunityType(OpportunityType opportunityType) {
        this.opportunityType_ = opportunityType;
    }
    /**
     * @return the probabilityInPercent
     */
    public float getProbabilityInPercent() {
        return this.probabilityInPercent_;
    }
    /**
     * @param probabilityInPercent the probabilityInPercent to set
     */
    public void setProbabilityInPercent(float probabilityInPercent) {
        this.probabilityInPercent_ = probabilityInPercent;
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
     * @return the project
     */
    public Project getProject() {
        return this.project_;
    }
    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project_ = project;
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
    
    
    
    
    

}
