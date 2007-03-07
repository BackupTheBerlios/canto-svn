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
    
    ELECTRONIC_MATERIAL("ELECTRONIC_MATERIAL"),
    BEAMER("BEAMER"),
    OFFICE_MATERIAL("OFFICE_MATERIAL"),
    VIRTUAL("VIRTUAL"),
    ROOM("ROOM");
    
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
