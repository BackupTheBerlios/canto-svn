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

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ChannelPackageType implements StringValuedEnum {
   
    MAIN("MAIN"),
    OPTION("OPTION");

    private String channelPackageType_;
    
    private ChannelPackageType(String channelPackageType){
        this.channelPackageType_ = channelPackageType;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return channelPackageType_;
    }

}
