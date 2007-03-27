/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.activity.call;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.activity.ActivityDirection;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Call extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5879361567030131227L;
    private ActivityDirection direction_;

    /**
     * @return the direction
     */
    public ActivityDirection getDirection() {
        return this.direction_;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(ActivityDirection direction) {
        this.direction_ = direction;
    }
   

}
