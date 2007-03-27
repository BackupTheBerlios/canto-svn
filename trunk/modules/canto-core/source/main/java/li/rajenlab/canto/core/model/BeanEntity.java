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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.canto.core.model.user.User;
import javax.persistence.EmbeddedId;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class BeanEntity implements Serializable {
    
    @Column(name="ENTERED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entered_;
    
    @Column(name="MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_;
    
    @Column(name="MODIFIED_BY")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="MODIFY_BY_USER", referencedColumnName = "ID")
    private User modifiedBy_;
    
    @Column(name="ASSIGNED_TO")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="ASSIGNED_TO_USER", referencedColumnName = "ID")
    private User assignedTo_;
    
    @Column(name="CREATE_BY")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="CREATE_BY_USER", referencedColumnName = "ID")
    private User createdBy_;
    
    @Column(name="OWNER")
    @ManyToOne(fetch=FetchType.EAGER, optional = true, targetEntity = li.rajenlab.canto.core.model.user.User.class)
    @JoinColumn(name="OWNER_USER", referencedColumnName = "ID")
    private User owner_;
  
    
    /**
     * @return the assignedTo
     */
    public User getAssignedTo() {
        return this.assignedTo_;
    }
    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(User assignedTo) {
        this.assignedTo_ = assignedTo;
    }
    /**
     * @return the createdBy
     */
    public User getCreatedBy() {
        return this.createdBy_;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(User createdBy) {
        this.createdBy_ = createdBy;
    }
    /**
     * @return the entered
     */
    public Date getEntered() {
        return this.entered_;
    }
    /**
     * @param entered the entered to set
     */
    public void setEntered(Date entered) {
        this.entered_ = entered;
    }
    /**
     * @return the id
     */
    public abstract Serializable getId();
    
    /**
     * @return the modified
     */
    public Date getModified() {
        return this.modified_;
    }
    /**
     * @param modified the modified to set
     */
    public void setModified(Date modified) {
        this.modified_ = modified;
    }
    /**
     * @return the modifiedBy
     */
    public User getModifiedBy() {
        return this.modifiedBy_;
    }
    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy_ = modifiedBy;
    }
    /**
     * @return the owner
     */
    public User getOwner() {
        return this.owner_;
    }
    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner_ = owner;
    }
    
}
