/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.participant;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public enum Presence implements StringValuedEnum {
    
    ONLINE("ONLINE"),
    BUSY("BUSY"),
    OFFLINE("OFFLINE"),
    AWAY("AWAY");
    
    
    private String presence_;
    
    
    private Presence (String presence){
        this.presence_ = presence;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return presence_;
    }

}
