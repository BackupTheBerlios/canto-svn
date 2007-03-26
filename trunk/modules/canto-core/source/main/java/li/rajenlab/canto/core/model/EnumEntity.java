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

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class EnumEntity implements Serializable {
    
    private String name_;
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
