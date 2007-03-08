/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:45 $
 * $LastChangedDate:2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) $
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-meeting/source/main/java/li/rajenlab/canto/meeting/domain/meeting/MeetingType.java $
 ******************************************************************************/

package li.rajenlab.canto.conference.domain.meeting;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id:MeetingType.java 45 2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public enum MeetingType implements StringValuedEnum {
    
    
    CONFERENCE_CALL("CONFERENCE_CALL"),
    STANDARD("STANDARD");
    
    
    private String meetingType_;
    
    
    private MeetingType(String meetingType){
        this.meetingType_ = meetingType;
    }


    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return meetingType_;
    }
    
    

}
