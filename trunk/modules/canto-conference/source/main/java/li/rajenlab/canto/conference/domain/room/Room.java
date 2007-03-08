/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:45 $
 * $LastChangedDate:2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) $
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-meeting/source/main/java/li/rajenlab/canto/meeting/domain/room/Room.java $
 ******************************************************************************/

package li.rajenlab.canto.conference.domain.room;

import li.rajenlab.canto.core.domain.resource.Resource;
import li.rajenlab.canto.core.domain.resource.ResourceType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id:Room.java 45 2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public class Room extends Resource {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4616859402880356394L;
    
    
    public static final String SETTINGS_TOTAL_SEAT = "seat";
    public static final String SETTINGS_FLOOR = "floor";
    
    
    public Room(){
        setResourceType(ResourceType.ROOM);
    }

    /**
     * Set seat
     * @param seat
     */
    public void setTotalSeat(int seat){
        addSettings(SETTINGS_TOTAL_SEAT, String.valueOf(seat));
    }
    
    /**
     * Get total seat
     * @return
     */
    public int getTotalSeat(){
        String value = getSettingsValue(SETTINGS_TOTAL_SEAT);
        return (value !=null ? Integer.parseInt(value) :  0);
    }
    
    public void setFloor(String floor){
        addSettings(SETTINGS_FLOOR,floor);
    }
    
    public String getFloor(){
        return getSettingsValue(SETTINGS_FLOOR);
    }
    
    
}
