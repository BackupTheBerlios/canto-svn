/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.booking;

import java.io.Serializable;

import li.rajenlab.canto.core.domain.product.Product;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class BookingItem implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 261911340245706164L;
    private Product product_;
    private int quantity_;
    private float price_;
    
    /**
     * @return the product
     */
    public Product getProduct() {
        return this.product_;
    }
    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product_ = product;
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
