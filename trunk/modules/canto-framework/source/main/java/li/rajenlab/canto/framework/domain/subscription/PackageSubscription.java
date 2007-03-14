/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.subscription;

import li.rajenlab.canto.framework.domain.product.ChannelPackage;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class PackageSubscription extends AbstractSubscription {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7203860604795731314L;
    
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
    
    
    
    

}
