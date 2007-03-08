/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.process;

import java.util.Date;

import li.rajenlab.common.service.guid.Guid;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProcessTimer {
    
    private String timerId_;
    private Date date_;

    /**
     * ProcessTimer which triggers immediately.
     *
     */
    public ProcessTimer() {
        setTimerId( new Guid().nextFormatedGUID() );
        setDate( new Date() );
    }
    
    /**
     * ProcessTimer which triggers at a certain time.
     *
     */
    public ProcessTimer( Date time ) {
        setTimerId( new Guid().nextFormatedGUID() );
        setDate(time);
    }
    
    /**
     * ProcessTimer which triggers at a certain time.
     *
     */
    public ProcessTimer( long time ) {
        setTimerId( new Guid().nextFormatedGUID() );
        setDate( new Date(time) );
    }
    
    public Date getDate() {
        return date_;
    }

    public void setDate(Date time) {
        this.date_ = time;
    }

    public String getTimerId() {
        return timerId_;
    }

    private void setTimerId(String timerId) {
        this.timerId_ = timerId;
    }

}
