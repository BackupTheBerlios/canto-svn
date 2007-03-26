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

import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.call.Call;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.common.Address;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.email.Email;
import li.rajenlab.canto.core.model.employee.Employee;
import li.rajenlab.canto.core.model.meeting.Meeting;
import li.rajenlab.canto.core.model.notes.Notes;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;
import li.rajenlab.canto.core.model.task.Task;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Lead extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2389190673097736723L;
    private Employee employee_;
    private Contact leadContact_;
    private boolean doNotCall_;
    private Contact referedBy_;
    private Address primaryAddress_;
    private Address altAddress_;
    private Account leadAccount_;
    private Opportunity opportunity_;
    private LeadStatus status_;
    private Case case_;
    private List<Task> tasks_;
    private List<Notes> notes_;
    private List<Meeting> meetings_;
    private List<Email> emails_;
    private List<Call> calls_;
    private LeadSource leadSource_;
    
    /**
     * @return the altAddress
     */
    public Address getAltAddress() {
        return this.altAddress_;
    }
    /**
     * @param altAddress the altAddress to set
     */
    public void setAltAddress(Address altAddress) {
        this.altAddress_ = altAddress;
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
     * @return the case
     */
    public Case getCase() {
        return this.case_;
    }
    /**
     * @param case1 the case to set
     */
    public void setCase(Case case1) {
        this.case_ = case1;
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
     * @return the employee
     */
    public Employee getEmployee() {
        return this.employee_;
    }
    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee_ = employee;
    }
    /**
     * @return the leadAccount
     */
    public Account getLeadAccount() {
        return this.leadAccount_;
    }
    /**
     * @param leadAccount the leadAccount to set
     */
    public void setLeadAccount(Account leadAccount) {
        this.leadAccount_ = leadAccount;
    }
    /**
     * @return the leadContact
     */
    public Contact getLeadContact() {
        return this.leadContact_;
    }
    /**
     * @param leadContact the leadContact to set
     */
    public void setLeadContact(Contact leadContact) {
        this.leadContact_ = leadContact;
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
     * @return the opportunity
     */
    public Opportunity getOpportunity() {
        return this.opportunity_;
    }
    /**
     * @param opportunity the opportunity to set
     */
    public void setOpportunity(Opportunity opportunity) {
        this.opportunity_ = opportunity;
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
    public Contact getReferedBy() {
        return this.referedBy_;
    }
    /**
     * @param referedBy the referedBy to set
     */
    public void setReferedBy(Contact referedBy) {
        this.referedBy_ = referedBy;
    }
  
    /**
     * @return the status
     */
    public LeadStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(LeadStatus status) {
        this.status_ = status;
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
