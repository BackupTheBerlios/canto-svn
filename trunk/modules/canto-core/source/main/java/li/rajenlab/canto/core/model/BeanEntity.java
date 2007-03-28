/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.canto.core.model.user.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class BeanEntity implements Serializable {
    
    @Column(name="ENTERED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entered;
    
    @Column(name="MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    
    @Column(name="MODIFIED_BY")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="MODIFY_BY_USER", referencedColumnName = "ID")
    private User modifiedBy;
    
    @Column(name="ASSIGNED_TO")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="ASSIGNED_TO_USER", referencedColumnName = "ID")
    private User assignedTo;
    
    @Column(name="CREATE_BY")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="CREATE_BY_USER", referencedColumnName = "ID")
    private User createdBy;
    
    @Column(name="OWNER")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="OWNER_USER", referencedColumnName = "ID")
    private User owner;
  
    
    /**
     * @return the assignedTo
     */
    public User getAssignedTo() {
        return this.assignedTo;
    }
    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return this.createdBy;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * @return the entered
     */
    public Date getEntered() {
        return this.entered;
    }
    /**
     * @param entered the entered to set
     */
    public void setEntered(Date entered) {
        this.entered = entered;
    }
  
    /**
     * @return the modified
     */
    public Date getModified() {
        return this.modified;
    }
    /**
     * @param modified the modified to set
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }
    /**
     * @return the modifiedBy
     */
    public User getModifiedBy() {
        return this.modifiedBy;
    }
    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    /**
     * @return the owner
     */
    public User getOwner() {
        return this.owner;
    }
    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
    
}
