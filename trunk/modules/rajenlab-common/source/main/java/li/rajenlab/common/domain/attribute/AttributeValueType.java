/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.attribute;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum AttributeValueType implements StringValuedEnum {
    
    TEXT("TEXT"),
    NUMBER("NUMBER"),
    DECIMAL("DECIMAL"),
    DATE("DATE"),
    LIST("LIST");

    private String type_;
    
    private AttributeValueType(String type){
        this.type_ = type;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return type_;
    }

}
