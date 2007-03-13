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
public enum ChannelPackageStatus implements StringValuedEnum {
    
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    PLANNED("PLANNED");

    private String status_;
    
    private ChannelPackageStatus(String status){
        this.status_ = status;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }

}
