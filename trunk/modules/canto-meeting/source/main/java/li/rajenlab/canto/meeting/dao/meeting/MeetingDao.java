/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.meeting.dao.meeting;

import java.util.List;

import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.canto.meeting.domain.meeting.Meeting;
import li.rajenlab.canto.meeting.domain.room.Room;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface MeetingDao extends SimpleDao<Meeting> {
    
    
    /**
     * Search all meetings of an organizer
     * @param organizer
     * @return
     */
    public List<Meeting> searchMeetingsByOrganizer(Organizer organizer);
    
    /**
     * Search all meetings of a room
     * @param room
     * @return
     */
    public List<Meeting> searchMeetingsByRoom(Room room);
    
    /**
     * Returns a list of all meeting that are currently taking place
     * @return
     */
    public List<Meeting> getRunningMeetings();

}
