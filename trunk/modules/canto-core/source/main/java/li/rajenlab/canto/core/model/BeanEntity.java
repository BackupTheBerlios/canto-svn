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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class BeanEntity implements Serializable {
    
    @Id
    @Column(name="ID")
    private Serializable id_;
    @Column(name="ENTERED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entered_;
    @Column(name="MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified_;
    @Column(name="MODIFIED_BY")
    @ManyToOne
    @JoinColumn(name="MODIFY_BY_USER", referencedColumnName = "ID")
    private User modifiedBy_;
    @Column(name="ASSIGNED_TO")
    @ManyToOne
    @JoinColumn(name="ASSIGNED_TO_USER", referencedColumnName = "ID")
    private User assignedTo_;
    @Column(name="CREATE_BY")
    @ManyToOne
    @JoinColumn(name="CREATE_BY_USER", referencedColumnName = "ID")
    private User createdBy_;
    @Column(name="OWNER")
    @ManyToOne
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
    public Serializable getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(Serializable id) {
        this.id_ = id;
    }
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