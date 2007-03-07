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

package li.rajenlab.canto.core.domain.organizer;

import li.rajenlab.canto.core.domain.contact.Contact;
import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Organizer extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4954248919283324552L;
    
    
    private String organizerId_;
    private Contact contact_; 
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
    
    

}
