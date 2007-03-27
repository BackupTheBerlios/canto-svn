/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.home;

import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.activity.call.Call;
import li.rajenlab.canto.core.model.activity.meeting.Meeting;
import li.rajenlab.canto.core.model.activity.task.Task;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.leads.Lead;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Home extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8722648041061686772L;
    private List<Call> myCalls_;
    private List<Account> myAccounts_;
    private List<Lead> myLeads_;
    private List<Meeting> myMeetings_;
    private List<Case> myOpenCases_;
    private List<Opportunity> myOpenOpportunites_;
    private List<Task> myOpenTasks_;
    
    /**
     * @return the myAccounts
     */
    public List<Account> getMyAccounts() {
        return this.myAccounts_;
    }
    /**
     * @param myAccounts the myAccounts to set
     */
    public void setMyAccounts(List<Account> myAccounts) {
        this.myAccounts_ = myAccounts;
    }
    /**
     * @return the myCalls
     */
    public List<Call> getMyCalls() {
        return this.myCalls_;
    }
    /**
     * @param myCalls the myCalls to set
     */
    public void setMyCalls(List<Call> myCalls) {
        this.myCalls_ = myCalls;
    }
    /**
     * @return the myLeads
     */
    public List<Lead> getMyLeads() {
        return this.myLeads_;
    }
    /**
     * @param myLeads the myLeads to set
     */
    public void setMyLeads(List<Lead> myLeads) {
        this.myLeads_ = myLeads;
    }
    /**
     * @return the myMeetings
     */
    public List<Meeting> getMyMeetings() {
        return this.myMeetings_;
    }
    /**
     * @param myMeetings the myMeetings to set
     */
    public void setMyMeetings(List<Meeting> myMeetings) {
        this.myMeetings_ = myMeetings;
    }
    /**
     * @return the myOpenCases
     */
    public List<Case> getMyOpenCases() {
        return this.myOpenCases_;
    }
    /**
     * @param myOpenCases the myOpenCases to set
     */
    public void setMyOpenCases(List<Case> myOpenCases) {
        this.myOpenCases_ = myOpenCases;
    }
    /**
     * @return the myOpenOpportunites
     */
    public List<Opportunity> getMyOpenOpportunites() {
        return this.myOpenOpportunites_;
    }
    /**
     * @param myOpenOpportunites the myOpenOpportunites to set
     */
    public void setMyOpenOpportunites(List<Opportunity> myOpenOpportunites) {
        this.myOpenOpportunites_ = myOpenOpportunites;
    }
    /**
     * @return the myOpenTasks
     */
    public List<Task> getMyOpenTasks() {
        return this.myOpenTasks_;
    }
    /**
     * @param myOpenTasks the myOpenTasks to set
     */
    public void setMyOpenTasks(List<Task> myOpenTasks) {
        this.myOpenTasks_ = myOpenTasks;
    }
    
    

}
