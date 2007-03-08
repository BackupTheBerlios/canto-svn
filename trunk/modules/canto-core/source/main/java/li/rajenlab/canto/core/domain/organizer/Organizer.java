/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:43 $
 * $LastChangedDate:2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-core/source/main/java/li/rajenlab/canto/core/domain/organizer/Organizer.java $
 ******************************************************************************/

package li.rajenlab.canto.core.domain.organizer;

import li.rajenlab.canto.core.domain.contact.Contact;
import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id:Organizer.java 43 2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public class Organizer extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4954248919283324552L;
    
    
    private String organizerId_;
    private Contact contact_; 
    private Contact billingContact_;
    private User user_;
    
    /**
     * @return the contact
     */
    public Contact getContact() {
        return this.contact_;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact_ = contact;
    }
    /**
     * @return the organizerId
     */
    public String getOrganizerId() {
        return this.organizerId_;
    }
    /**
     * @param organizerId the organizerId to set
     */
    public void setOrganizerId(String organizerId) {
        this.organizerId_ = organizerId;
    }
    /**
     * @return the user
     */
    public User getUser() {
        return this.user_;
    }
    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user_ = user;
    }
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
    
    

}
