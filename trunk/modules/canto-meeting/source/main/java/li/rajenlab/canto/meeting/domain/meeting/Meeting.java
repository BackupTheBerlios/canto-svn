/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.meeting.domain.meeting;

import java.util.HashSet;
import java.util.Set;

import li.rajenlab.canto.core.domain.AbstractEventEntity;
import li.rajenlab.canto.core.domain.catering.CateringOrder;
import li.rajenlab.canto.core.domain.participant.Participant;
import li.rajenlab.canto.meeting.domain.room.Room;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Meeting extends AbstractEventEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5341581107313263558L;
    
    
    private Set<Participant> acceptedInvitees_;
    private Set<Participant> invitees_;
    private boolean confidential_;
    private MeetingType meetingType_;
    private CateringOrder cateringOrder_;
    private Room room_;
    private String meetingId_;
  
    
    
    /**
     * @return the acceptedInvitees
     */
    public Set<Participant> getAcceptedInvitees() {
        return this.acceptedInvitees_;
    }
    /**
     * @param acceptedInvitees the acceptedInvitees to set
     */
    public void setAcceptedInvitees(Set<Participant> acceptedInvitees) {
        this.acceptedInvitees_ = acceptedInvitees;
    }
    
    public synchronized void addAcceptedInvitee(Participant participant){
        if (getAcceptedInvitees()!=null){
            acceptedInvitees_ = new HashSet<Participant>();
        }
        acceptedInvitees_.add(participant);
    }
    
    public synchronized void removeAcceptedInvitee(Participant participant){
        if (getAcceptedInvitees()!=null){
            acceptedInvitees_.remove(participant);
        }
    }
  
    /**
     * @return the invitees
     */
    public Set<Participant> getInvitees() {
        return this.invitees_;
    }
    /**
     * @param invitees the invitees to set
     */
    public void setInvitees(Set<Participant> invitees) {
        this.invitees_ = invitees;
    }
    
    public synchronized void addInvitee(Participant participant){
        if (getInvitees()!=null){
            invitees_ = new HashSet<Participant>();
        }
        invitees_.add(participant);
    }
    
    public synchronized void removeInvitee(Participant participant){
        if (getInvitees()!=null){
            invitees_.remove(participant);
        }
    }
    
    /**
     * @return the confidential
     */
    public boolean isConfidential() {
        return this.confidential_;
    }
    /**
     * @param confidential the confidential to set
     */
    public void setConfidential(boolean confidential) {
        this.confidential_ = confidential;
    }
    /**
     * @return the meetingType
     */
    public MeetingType getMeetingType() {
        return this.meetingType_;
    }
    /**
     * @param meetingType the meetingType to set
     */
    public void setMeetingType(MeetingType meetingType) {
        this.meetingType_ = meetingType;
    }
    /**
     * @return the cateringOrder
     */
    public CateringOrder getCateringOrder() {
        return this.cateringOrder_;
    }
    /**
     * @param cateringOrder the cateringOrder to set
     */
    public void setCateringOrder(CateringOrder cateringOrder) {
        this.cateringOrder_ = cateringOrder;
    }
    /**
     * @return the room
     */
    public Room getRoom() {
        return this.room_;
    }
    /**
     * @param room the room to set
     */
    public void setRoom(Room room) {
        this.room_ = room;
    }
    /**
     * @return the meetingId
     */
    public String getMeetingId() {
        return this.meetingId_;
    }
    /**
     * @param meetingId the meetingId to set
     */
    public void setMeetingId(String meetingId) {
        this.meetingId_ = meetingId;
    }


    

   
   
}
