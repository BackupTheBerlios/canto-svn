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

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Catering extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3018424312509652724L;
    
    
    private CateringType type_;
    private float        price_;
    private String       name_;
    private String       code_;
    
    /**
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the price
     */
    public float getPrice() {
        return this.price_;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price_ = price;
    }
    /**
     * @return the type
     */
    public CateringType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(CateringType type) {
        this.type_ = type;
    }
    
    
    

}
