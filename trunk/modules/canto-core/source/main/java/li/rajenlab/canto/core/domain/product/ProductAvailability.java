/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.product;

import java.util.Date;

import li.rajenlab.canto.core.domain.market.Market;
import li.rajenlab.canto.core.domain.market.SalesChannel;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProductAvailability extends AbstractEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1929089197650227885L;
    private Market market_;
    private Product product_;
    private SalesChannel salesChannel_;
    private Date introductionDate_;
    private Date expiryDate_;
    
    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return this.expiryDate_;
    }
    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate_ = expiryDate;
    }
    /**
     * @return the introductionDate
     */
    public Date getIntroductionDate() {
        return this.introductionDate_;
    }
    /**
     * @param introductionDate the introductionDate to set
     */
    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate_ = introductionDate;
    }
    /**
     * @return the market
     */
    public Market getMarket() {
        return this.market_;
    }
    /**
     * @param market the market to set
     */
    public void setMarket(Market market) {
        this.market_ = market;
    }
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
     * @return the salesChannel
     */
    public SalesChannel getSalesChannel() {
        return this.salesChannel_;
    }
    /**
     * @param salesChannel the salesChannel to set
     */
    public void setSalesChannel(SalesChannel salesChannel) {
        this.salesChannel_ = salesChannel;
    }
    
    
    
    

}
