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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class EnumEntity implements Serializable {
    
    @Column(name="NAME",unique=true,nullable=true, insertable = false, updatable = false)
    private String name_;
    
    @Id
    @Column(name="ID", insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Serializable id_;

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
    
    

}
