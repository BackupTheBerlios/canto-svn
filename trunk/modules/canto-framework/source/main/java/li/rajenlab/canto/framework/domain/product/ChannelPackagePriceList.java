/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.product;

import li.rajenlab.canto.framework.domain.price.AbstractPrice;
import li.rajenlab.canto.framework.domain.price.PriceList;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ChannelPackagePriceList extends AbstractPrice {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 123051054156871638L;
    
    private PriceList priceList_;
    private ChannelPackage channelPackage_;
    
    /**
     * @return the channelPackage
     */
    public ChannelPackage getChannelPackage() {
        return this.channelPackage_;
    }
    /**
     * @param channelPackage the channelPackage to set
     */
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage_ = channelPackage;
    }
    /**
     * @return the priceList
     */
    public PriceList getPriceList() {
        return this.priceList_;
    }
    /**
     * @param priceList the priceList to set
     */
    public void setPriceList(PriceList priceList) {
        this.priceList_ = priceList;
    }
    
    
    

}
