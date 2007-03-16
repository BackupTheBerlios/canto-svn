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
public class AttributeValue extends AbstractLocaleEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2835781210280468758L;
    private Attribute attribute_;
    private String value_;

    /**
     * @return the attribute
     */
    public Attribute getAttribute() {
        return this.attribute_;
    }

    /**
     * @param attribute the attribute to set
     */
    public void setAttribute(Attribute attribute) {
        this.attribute_ = attribute;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return this.value_;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value_ = value;
    }
    
    

}
