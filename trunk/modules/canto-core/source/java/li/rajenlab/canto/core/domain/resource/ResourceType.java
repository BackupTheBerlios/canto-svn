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
public enum ResourceType implements StringValuedEnum {
    
    ROOM("ROOM"),
    STAND("STAND"),
    UNDEFINED("UNDEFINED");
    
    private String resourceType_;
    
    
    private ResourceType(String resourceType){
        this.resourceType_ = resourceType;
    }


    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return resourceType_;
    }

    
}
