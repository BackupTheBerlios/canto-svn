/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.call;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.calendar.outlook.MSOutlook;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.notes.Notes;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Call extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7989156435354586470L;
    
    private CallStatus status_;
    private Date startDate_;
    private Date endDate_;
    private int durationHour_;
    private int durationMinute_;
    private Contact contact_;
    private Account account_;
    private Direction direction_;
    private Date reminderDate_;
    private Opportunity opportunity_;
    private Case case_;
    private List<Notes> notes_;
    private MSOutlook msOutlook_;
    
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
     * @return the direction
     */
    public Direction getDirection() {
        return this.direction_;
    }
    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction_ = direction;
    }
    /**
     * @return the durationHour
     */
    public int getDurationHour() {
        return this.durationHour_;
    }
    /**
     * @param durationHour the durationHour to set
     */
    public void setDurationHour(int durationHour) {
        this.durationHour_ = durationHour;
    }
    /**
     * @return the durationMinute
     */
    public int getDurationMinute() {
        return this.durationMinute_;
    }
    /**
     * @param durationMinute the durationMinute to set
     */
    public void setDurationMinute(int durationMinute) {
        this.durationMinute_ = durationMinute;
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
     * @return the msOutlook
     */
    public MSOutlook getMsOutlook() {
        return this.msOutlook_;
    }
    /**
     * @param msOutlook the msOutlook to set
     */
    public void setMsOutlook(MSOutlook msOutlook) {
        this.msOutlook_ = msOutlook;
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
    public CallStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(CallStatus status) {
        this.status_ = status;
    }
    
    
    
    
   
    

}
