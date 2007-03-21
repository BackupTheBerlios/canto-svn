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

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum ProductStatus implements StringValuedEnum {
    
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String status_;
    
    private ProductStatus(String status){
        this.status_ = status;
    }
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }
    
    

}
