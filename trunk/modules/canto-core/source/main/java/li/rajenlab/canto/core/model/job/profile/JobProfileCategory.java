/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job.profile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="JOBPROFILE_CATEGORY")
public class JobProfileCategory implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3748474698371604611L;

    @Id
    @Column(name="id",unique=true,nullable=false)
    private String id_;
    
    @Column(name="name",unique=true,nullable=false)
    private String name_;
    
    @ManyToOne(optional=false,targetEntity=li.rajenlab.canto.core.model.job.profile.JobProfileCategory.class,fetch=FetchType.LAZY)
    @JoinColumn(name="PARENT_ID", nullable=false)
    private JobProfileCategory parent_;

    
    /**
     * @return the id
     */
    public String getId() {
        return this.id_;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
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

    /**
     * @return the parent
     */
    public JobProfileCategory getParent() {
        return this.parent_;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(JobProfileCategory parent) {
        this.parent_ = parent;
    }
    
    
    
    
    

}
