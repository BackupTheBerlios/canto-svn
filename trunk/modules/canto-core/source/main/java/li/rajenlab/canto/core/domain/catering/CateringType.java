/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.catering;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum CateringType implements StringValuedEnum {
    
    
    FOOD("FOOD"),
    DRINK("DRINK");
    
    private String cateringType_;
    
    
    private CateringType(String cateringType){
        this.cateringType_ = cateringType;
    }


    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return cateringType_;
    }

    
}
