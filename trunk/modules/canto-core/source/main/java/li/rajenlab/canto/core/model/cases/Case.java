/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.cases;

import java.util.List;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.call.Call;
import li.rajenlab.canto.core.model.email.Email;
import li.rajenlab.canto.core.model.meeting.Meeting;
import li.rajenlab.canto.core.model.notes.Notes;
import li.rajenlab.canto.core.model.task.Task;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Case extends Entity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3134358677233735280L;
    
    private String caseId_;
    private String resolution_;
    private int priority_;
    private CaseStatus status_;
    private CaseType type_;
    
    private Account account_;
    private List<Task> tasks_;
    private List<Notes> notes_;
    private List<Call> calls_;
    private List<Meeting> meetings_;
    private List<Email> emails_;
    
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
     * @return the caseId
     */
    public String getCaseId() {
        return this.caseId_;
    }
    /**
     * @param caseId the caseId to set
     */
    public void setCaseId(String caseId) {
        this.caseId_ = caseId;
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
     * @return the priority
     */
    public int getPriority() {
        return this.priority_;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority_ = priority;
    }
    /**
     * @return the resolution
     */
    public String getResolution() {
        return this.resolution_;
    }
    /**
     * @param resolution the resolution to set
     */
    public void setResolution(String resolution) {
        this.resolution_ = resolution;
    }
    /**
     * @return the status
     */
    public CaseStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(CaseStatus status) {
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
    /**
     * @return the type
     */
    public CaseType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(CaseType type) {
        this.type_ = type;
    }
    
    

}
