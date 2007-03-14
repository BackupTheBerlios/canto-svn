/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.price;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractPrice extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7140754032920928799L;
    
    private PriceType priceType_;
    private float     price_;
    
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
     * @return the priceType
     */
    public PriceType getPriceType() {
        return this.priceType_;
    }
    /**
     * @param priceType the priceType to set
     */
    public void setPriceType(PriceType priceType) {
        this.priceType_ = priceType;
    }
    

}
