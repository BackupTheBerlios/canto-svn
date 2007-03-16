/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.price;

import li.rajenlab.canto.core.domain.product.ProductAvailability;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductPriceList extends AbstractPriceList {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1147737957811300764L;
    private float price_;
    private ProductAvailability availability_;
    
    /**
     * @return the availability
     */
    public ProductAvailability getAvailability() {
        return this.availability_;
    }
    /**
     * @param availability the availability to set
     */
    public void setAvailability(ProductAvailability availability) {
        this.availability_ = availability;
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
