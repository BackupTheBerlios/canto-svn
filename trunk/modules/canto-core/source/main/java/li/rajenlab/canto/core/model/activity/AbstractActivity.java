/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.contact.Contact;
import li.rajenlab.canto.core.model.leads.Lead;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractActivity extends BeanEntity {
    
    private String subject_;
    private Date startDateTime_;
    private ActivityStatus status_;
    private int durationHours_;
    private int durationMinutes_;
    private ActivityRelatedRecord relatedRecord_;
    private Account relatedAccount_;
    private Opportunity relatedOpportunity_;
    private Lead relatedLead_;
    private Contact relatedContact_;
    private Date reminderDate_;
    private boolean remindMe_;
    private List<ActivityNote> activityNotes_;
    private String description_;
    
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
     * @return the durationHours
     */
    public int getDurationHours() {
        return this.durationHours_;
    }
    /**
     * @param durationHours the durationHours to set
     */
    public void setDurationHours(int durationHours) {
        this.durationHours_ = durationHours;
    }
    /**
     * @return the durationMinutes
     */
    public int getDurationMinutes() {
        return this.durationMinutes_;
    }
    /**
     * @param durationMinutes the durationMinutes to set
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes_ = durationMinutes;
    }
    /**
     * @return the relatedAccount
     */
    public Account getRelatedAccount() {
        return this.relatedAccount_;
    }
    /**
     * @param relatedAccount the relatedAccount to set
     */
    public void setRelatedAccount(Account relatedAccount) {
        this.relatedAccount_ = relatedAccount;
    }
    /**
     * @return the relatedContact
     */
    public Contact getRelatedContact() {
        return this.relatedContact_;
    }
    /**
     * @param relatedContact the relatedContact to set
     */
    public void setRelatedContact(Contact relatedContact) {
        this.relatedContact_ = relatedContact;
    }
    /**
     * @return the relatedLead
     */
    public Lead getRelatedLead() {
        return this.relatedLead_;
    }
    /**
     * @param relatedLead the relatedLead to set
     */
    public void setRelatedLead(Lead relatedLead) {
        this.relatedLead_ = relatedLead;
    }
    /**
     * @return the relatedOpportunity
     */
    public Opportunity getRelatedOpportunity() {
        return this.relatedOpportunity_;
    }
    /**
     * @param relatedOpportunity the relatedOpportunity to set
     */
    public void setRelatedOpportunity(Opportunity relatedOpportunity) {
        this.relatedOpportunity_ = relatedOpportunity;
    }
    /**
     * @return the relatedRecord
     */
    public ActivityRelatedRecord getRelatedRecord() {
        return this.relatedRecord_;
    }
    /**
     * @param relatedRecord the relatedRecord to set
     */
    public void setRelatedRecord(ActivityRelatedRecord relatedRecord) {
        this.relatedRecord_ = relatedRecord;
    }
    /**
     * @return the reminderDate
     */
    public Date getReminderDate() {
        return this.reminderDate_;
    }
    /**
     * @param reminderDate the reminderDate to set
     */
    public void setReminderDate(Date reminderDate) {
        this.reminderDate_ = reminderDate;
    }
    /**
     * @return the remindMe
     */
    public boolean isRemindMe() {
        return this.remindMe_;
    }
    /**
     * @param remindMe the remindMe to set
     */
    public void setRemindMe(boolean remindMe) {
        this.remindMe_ = remindMe;
    }
    /**
     * @return the startDateTime
     */
    public Date getStartDateTime() {
        return this.startDateTime_;
    }
    /**
     * @param startDateTime the startDateTime to set
     */
    public void setStartDateTime(Date startDateTime) {
        this.startDateTime_ = startDateTime;
    }
    /**
     * @return the status
     */
    public ActivityStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(ActivityStatus status) {
        this.status_ = status;
    }
    /**
     * @return the subject
     */
    public String getSubject() {
        return this.subject_;
    }
    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject_ = subject;
    }
    /**
     * @return the activityNotes
     */
    public List<ActivityNote> getActivityNotes() {
        return this.activityNotes_;
    }
    /**
     * @param activityNotes the activityNotes to set
     */
    public void setActivityNotes(List<ActivityNote> activityNotes) {
        this.activityNotes_ = activityNotes;
    }
    
    

}
