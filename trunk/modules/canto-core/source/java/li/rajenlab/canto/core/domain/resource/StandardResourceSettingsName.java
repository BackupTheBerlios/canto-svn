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

package li.rajenlab.canto.core.domain.resource;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public enum StandardResourceSettingsName implements StringValuedEnum {
    
    
    STANDARD_PRICE("STANDARD_PRICE"),
    LOCATION("LOCATION");
    
    private String settingsName_;

    
    private StandardResourceSettingsName(String settingsName){
        this.settingsName_ = settingsName;
    }
    
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return settingsName_;
    }
    
    
    

}
