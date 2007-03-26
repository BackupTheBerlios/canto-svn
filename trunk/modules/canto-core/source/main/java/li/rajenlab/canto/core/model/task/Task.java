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

import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Task extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8953170409141192203L;
    private String name_;
    private String description_;
    private TaskStatus status_;
    
    private Date dateDue_;
    private Date dateStart_;
    private int priority_;
    private Task parent_;
    private Account account_;
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
     * @return the name
     */
    @Override
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name_ = name;
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
