/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.core.domain.participant;

import li.rajenlab.core.domain.common.AbstractEntity;
import li.rajenlab.core.domain.contact.Contact;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Participant extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4310923529381892983L;

    private Contact mainContact_; 
    private Contact billingContact_;
    
    
    /**
     * @return the billingContact
     */
    public Contact getBillingContact() {
        return this.billingContact_;
    }
    /**
     * @param billingContact the billingContact to set
     */
    public void setBillingContact(Contact billingContact) {
        this.billingContact_ = billingContact;
    }
    /**
     * @return the mainContact
     */
    public Contact getMainContact() {
        return this.mainContact_;
    }
    /**
     * @param mainContact the mainContact to set
     */
    public void setMainContact(Contact mainContact) {
        this.mainContact_ = mainContact;
    }
    
    
    
}
