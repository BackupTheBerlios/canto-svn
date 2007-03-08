/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:45 $
 * $LastChangedDate:2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) $
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-meeting/source/main/java/li/rajenlab/canto/meeting/domain/room/Room.java $
 ******************************************************************************/

package li.rajenlab.canto.conference.domain.vroom;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import li.rajenlab.canto.core.domain.participant.Participant;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id:Room.java 45 2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public class VirtualRoom implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4616859402880356394L;
    
    private String uid_;
    private Set<Participant> participants_ = new HashSet<Participant>();
    private String name_;
    
    /**
     * @return the participants
     */
    public Set<Participant> getParticipants() {
        return this.participants_;
    }
 
    
    /**
     * Join the room as participant
     * @param participant
     */
    public  synchronized void join(Participant participant){
        participants_.add(participant);
    }
    
    /**
     * Live the virtual room as participant
     * @param participant
     */
    public synchronized void leave(Participant participant){
        participants_.remove(participant);
    }
    
    /**
     * @return the uid
     */
    public String getUid() {
        return this.uid_;
    }
    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid_ = uid;
    }
   
    
    
}
