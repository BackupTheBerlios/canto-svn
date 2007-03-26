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

import javax.persistence.MappedSuperclass;

import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class BeanEntity implements Serializable {
    
    private Serializable id_;
    private Date entered_;
    private Date modified_;
    private User modifiedBy_;
    private User assignedTo_;
    private User createdBy_;
    private User owner_;
    private String name_;
    private String description_;
    
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
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    
    
    
    

}
