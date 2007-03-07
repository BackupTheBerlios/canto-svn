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

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
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
