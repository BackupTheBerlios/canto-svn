/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.project;

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Project extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1633191516596693965L;
    
    
    
    private Date startDate_;
    private Date endDate_;
    private Account account_;
    private Contact contact_;
    private Opportunity opportunity_;
    private int estimatedEfforts_;
    private int actualEfforts_;

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
     * @return the actualEfforts
     */
    public int getActualEfforts() {
        return this.actualEfforts_;
    }
    /**
     * @param actualEfforts the actualEfforts to set
     */
    public void setActualEfforts(int actualEfforts) {
        this.actualEfforts_ = actualEfforts;
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
     * @return the estimatedEfforts
     */
    public int getEstimatedEfforts() {
        return this.estimatedEfforts_;
    }
    /**
     * @param estimatedEfforts the estimatedEfforts to set
     */
    public void setEstimatedEfforts(int estimatedEfforts) {
        this.estimatedEfforts_ = estimatedEfforts;
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
    



}
