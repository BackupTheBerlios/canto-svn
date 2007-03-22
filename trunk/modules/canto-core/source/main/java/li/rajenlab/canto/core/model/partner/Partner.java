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

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import li.rajenlab.canto.core.model.Contact;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="PARTNER")
public class Partner implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7919354649850086383L;

  
    @Id
    @SequenceGenerator(name="PARTNER_SEQ", allocationSize=25)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_SEQ")
    @Column(name="PARTNER_ID",unique=true)
    private String partnerId_;
    
    @Column(name="NAME",nullable=false)
    private String name_;
    
    @ManyToOne
    private PartnerType partnerType_;
    
    @Embedded
    private Contact contact_;

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
     * @return the partnerId
     */
    public String getPartnerId() {
        return this.partnerId_;
    }

    /**
     * @param partnerId the partnerId to set
     */
    public void setPartnerId(String partnerId) {
        this.partnerId_ = partnerId;
    }

    /**
     * @return the partnerType
     */
    public PartnerType getPartnerType() {
        return this.partnerType_;
    }

    /**
     * @param partnerType the partnerType to set
     */
    public void setPartnerType(PartnerType partnerType) {
        this.partnerType_ = partnerType;
    }
    
    

}
