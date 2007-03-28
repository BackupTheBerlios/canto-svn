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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="EnumType")
@Table(name="ENUM_TYPE")
@DiscriminatorColumn(name="TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class EnumEntity implements Serializable {
    
    @Column(name="NAME",unique=true,nullable=true, insertable = false, updatable = false)
    private String name;
    
    @Id
    @Column(name="ID", insertable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Serializable id;

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Serializable getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Serializable id) {
        this.id = id;
    }
    
    

}
