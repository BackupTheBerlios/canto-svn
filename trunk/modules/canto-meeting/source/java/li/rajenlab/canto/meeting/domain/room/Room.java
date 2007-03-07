/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.meeting.domain.room;

import li.rajenlab.canto.core.domain.resource.Resource;
import li.rajenlab.canto.core.domain.resource.ResourceType;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
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
