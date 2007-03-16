/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.crm;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Organization extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 634706894699818768L;
    private Contact legalContact_;
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
     * @return the legalContact
     */
    public Contact getLegalContact() {
        return this.legalContact_;
    }
    /**
     * @param legalContact the legalContact to set
     */
    public void setLegalContact(Contact legalContact) {
        this.legalContact_ = legalContact;
    }
    
    

}
