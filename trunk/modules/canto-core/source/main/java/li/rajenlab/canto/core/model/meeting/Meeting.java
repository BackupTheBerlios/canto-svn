/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.meeting;

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.calendar.outlook.MSOutlook;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.employee.Employee;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Meeting extends Entity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -828244100221741702L;
    
    
    private String location_;
    private Date startDate_;
    private Date endDate_;
    private Contact contact_;
    private Employee organizer_;
    private List<Employee> attendees_;
    private Date reminderDate_;
    private Account account_;
    private Opportunity opportunity_;
    private Case case_;
    private MSOutlook msOutlook_;
    private MeetingStatus status_;
    
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
     * @return the attendees
     */
    public List<Employee> getAttendees() {
        return this.attendees_;
    }
    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(List<Employee> attendees) {
        this.attendees_ = attendees;
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
     * @return the location
     */
    public String getLocation() {
        return this.location_;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location_ = location;
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
     * @return the organizer
     */
    public Employee getOrganizer() {
        return this.organizer_;
    }
    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(Employee organizer) {
        this.organizer_ = organizer;
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
    public MeetingStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(MeetingStatus status) {
        this.status_ = status;
    }



}
