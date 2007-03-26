/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.task;

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.common.domain.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name="TASK")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Task extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8953170409141192203L;
    @Column(name="STATUS")
    private TaskStatus status_;
    
    @Column(name="DATE_DUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDue_;
    @Column(name="DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart_;
    @Column(name="PRIORTY")
    private int priority_;
    @Column(name="PARENT")
    @ManyToOne
    @JoinColumn(name="PARENT_ID", referencedColumnName = "ID")
    private Task parent_;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    private Account account_;
    @Column(name="TYPE")
    private TaskType type_;
    
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
     * @return the dateDue
     */
    public Date getDateDue() {
        return this.dateDue_;
    }
    /**
     * @param dateDue the dateDue to set
     */
    public void setDateDue(Date dateDue) {
        this.dateDue_ = dateDue;
    }
    /**
     * @return the dateStart
     */
    public Date getDateStart() {
        return this.dateStart_;
    }
    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Date dateStart) {
        this.dateStart_ = dateStart;
    }
    
    /**
     * @return the parent
     */
    public Task getParent() {
        return this.parent_;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(Task parent) {
        this.parent_ = parent;
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
     * @return the status
     */
    public TaskStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(TaskStatus status) {
        this.status_ = status;
    }
    /**
     * @return the type
     */
    public TaskType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(TaskType type) {
        this.type_ = type;
    }
    
    
    
}
