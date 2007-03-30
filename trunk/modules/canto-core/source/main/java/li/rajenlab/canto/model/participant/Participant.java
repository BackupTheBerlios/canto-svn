/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.model.participant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import li.rajenlab.canto.model.user.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="PARTICIPANT")
public class Participant implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5476691069141883846L;

    @Id
    @Column(name="PARTICIPANT_ID")
    private String participantId;
    
    @Column(name="DISPLAY_NAME",length=100)
    private String displayName;
    
    @Column(name="USER")
    @ManyToOne
    @JoinColumn(name="USER_ID", referencedColumnName = "USERNAME")
    private User user;
    
    @Transient
    private Presence presence;
    
    @Transient
    private ParticipantState participantState;
   

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the participantId
     */
    public String getParticipantId() {
        return this.participantId;
    }

    /**
     * @param participantId the participantId to set
     */
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    /**
     * @return the participantState
     */
    public ParticipantState getParticipantState() {
        return this.participantState;
    }

    /**
     * @param participantState the participantState to set
     */
    public void setParticipantState(ParticipantState participantState) {
        this.participantState = participantState;
    }

    /**
     * @return the presence
     */
    public Presence getPresence() {
        return this.presence;
    }

    /**
     * @param presence the presence to set
     */
    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
    

}
