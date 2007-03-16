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

import li.rajenlab.common.domain.AbstractLocaleEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Attribute extends AbstractLocaleEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1968438245912081247L;
    private AttributeValueType valueType_;
    

    /**
     * @return the valueType
     */
    public AttributeValueType getValueType() {
        return this.valueType_;
    }

    /**
     * @param valueType the valueType to set
     */
    public void setValueType(AttributeValueType valueType) {
        this.valueType_ = valueType;
    }
    
    

}
