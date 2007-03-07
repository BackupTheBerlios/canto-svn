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

package li.rajenlab.canto.core.domain.participant;

import java.util.Properties;
import java.util.Set;

import li.rajenlab.canto.core.domain.contact.Contact;
import li.rajenlab.common.domain.AbstractEntity;
import li.rajenlab.common.domain.security.User;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Participant extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5128901927756989647L;
    
    private String participantId_;
    private User user_;
    private Contact contact_; 
    private Presence presence_;
    private Properties settings_;
    private Set<ParticipantCategory> categories_;
    
   
    /**
     * @return the presence
     */
    public Presence getPresence() {
        return this.presence_;
    }
    /**
     * @param presence the presence to set
     */
    public void setPresence(Presence presence) {
        this.presence_ = presence;
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
     * @return the settings
     */
    public Properties getSettings() {
        return this.settings_;
    }
    /**
     * @param settings the settings to set
     */
    public void setSettings(Properties settings) {
        this.settings_ = settings;
    }
    /**
     * @return the participantId
     */
    public String getParticipantId() {
        return this.participantId_;
    }
    /**
     * @param participantId the participantId to set
     */
    public void setParticipantId(String participantId) {
        this.participantId_ = participantId;
    }
    /**
     * @return the categories
     */
    public Set<ParticipantCategory> getCategories() {
        return this.categories_;
    }
    /**
     * @param categories the categories to set
     */
    public void setCategories(Set<ParticipantCategory> categories) {
        this.categories_ = categories;
    }
    
    
    
    
    

}