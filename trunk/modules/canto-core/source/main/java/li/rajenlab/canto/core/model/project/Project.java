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
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="PROJECT")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Project extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1633191516596693965L;
    
    
    
    @Column(name="START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate_;
    @Column(name="END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate_;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account_;
    @ManyToOne
    @JoinColumn(name="CONTACT_ID", referencedColumnName = "ID")
    private Contact contact_;
    @ManyToOne
    @JoinColumn(name="OPPORTUNITY_ID")
    private Opportunity opportunity_;
    @Column(name="ESTIMATED_EFFORS")
    private int estimatedEfforts_;
    @Column(name="ACCTUAL_EFFORTS")
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
