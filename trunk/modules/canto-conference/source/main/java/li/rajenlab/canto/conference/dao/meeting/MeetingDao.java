/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:45 $
 * $LastChangedDate:2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) $
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-meeting/source/main/java/li/rajenlab/canto/meeting/dao/meeting/MeetingDao.java $
 ******************************************************************************/

package li.rajenlab.canto.conference.dao.meeting;

import java.util.List;

import li.rajenlab.canto.conference.domain.meeting.Meeting;
import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id:MeetingDao.java 45 2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public interface MeetingDao extends SimpleDao<Meeting> {
    
    
    /**
     * Search all meetings of an organizer
     * @param organizer
     * @return
     */
    public List<Meeting> searchMeetingsByOrganizer(Organizer organizer);
    
    /**
     * Returns a list of all meeting that are currently taking place
     * @return
     */
    public List<Meeting> getRunningMeetings();

}
