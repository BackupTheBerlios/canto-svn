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

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@MappedSuperclass
public abstract class SimpleIdBeanEntity extends BeanEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @TableGenerator(name="ID_GENERATOR", table = "ID_GENERATOR", pkColumnName = "KEY", valueColumnName = "VALUE", pkColumnValue = "PK_ID")
    private String id;
    
    /**
     * @see li.rajenlab.canto.core.model.BeanEntity#getId()
     */
    @Override
    public Serializable getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    

}
