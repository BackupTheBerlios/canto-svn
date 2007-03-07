/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.module;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ControlSetting implements StringValuedEnum {
    
    RUNNABLE("RUNNABLE"),
    STOPPED("STOPPED");
    
    private final String  controllSettings_;
    
    
    private ControlSetting(final String controllSettings){
        this.controllSettings_ = controllSettings;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return this.controllSettings_;
    }

}
