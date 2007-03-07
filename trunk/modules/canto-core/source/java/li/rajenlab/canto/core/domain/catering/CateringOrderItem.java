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

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class CateringOrderItem implements Serializable {
    
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4409672614187369353L;
    
    private int quantity_;
    private Catering catering_;
    private float  price_;
    
    /**
     * @return the catering
     */
    public Catering getCatering() {
        return this.catering_;
    }
    /**
     * @param catering the catering to set
     */
    public void setCatering(Catering catering) {
        this.catering_ = catering;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity_;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity_ = quantity;
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
    
    
    

}
