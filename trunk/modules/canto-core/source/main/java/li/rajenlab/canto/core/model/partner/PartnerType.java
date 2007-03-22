/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.partner;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="PARTNER_TYPE")
public class PartnerType implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4181842100946407994L;

    @Id
    @Column(name="PARTNERTYPE_ID",unique=true)
    private String id_;
    
    @Column(name="NAME",unique=true)
    private String name_;
   
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
    
    
    
    
    

}
