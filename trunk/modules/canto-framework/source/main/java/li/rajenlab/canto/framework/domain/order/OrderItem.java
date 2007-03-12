/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import java.io.Serializable;

import li.rajenlab.canto.framework.domain.product.Product;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderItem implements Serializable {
    
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7507714200010785424L;
    
    private Product product_;
    private int quantity_;
    private Order order_;
    
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
     * @return the order
     */
    public Order getOrder() {
        return this.order_;
    }
    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order_ = order;
    }
   
    
}
