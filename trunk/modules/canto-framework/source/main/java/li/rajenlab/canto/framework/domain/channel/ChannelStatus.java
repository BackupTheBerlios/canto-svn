/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.channel;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ChannelStatus implements StringValuedEnum {
    
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    IN_INTERFERENCE("IN_INTERFERENCE"),
    IN_MAINTENANCE("IN_MAINTENANCE");

    private String status_;
    
    private ChannelStatus(String status){
        status_ = status;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
       return status_;
    }
    
    

}
