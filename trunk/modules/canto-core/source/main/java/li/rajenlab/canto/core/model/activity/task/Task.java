/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity.task;

import java.util.Date;

import li.rajenlab.canto.core.model.activity.AbstractActivity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Task extends AbstractActivity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3040528822748686754L;
    private TaskStatus taskStatus_;
    private TaskType taskType_;
    private Date dueDate_;
    private String priority_;
  
    
    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return this.dueDate_;
    }
    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate_ = dueDate;
    }
    /**
     * @return the priority
     */
    public String getPriority() {
        return this.priority_;
    }
    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority_ = priority;
    }
    
    /**
     * @return the taskStatus
     */
    public TaskStatus getTaskStatus() {
        return this.taskStatus_;
    }
    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus_ = taskStatus;
    }
    /**
     * @return the taskType
     */
    public TaskType getTaskType() {
        return this.taskType_;
    }
    /**
     * @param taskType the taskType to set
     */
    public void setTaskType(TaskType taskType) {
        this.taskType_ = taskType;
    }
    
    

}
