/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.job.profile;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum JobProfileStatus implements StringValuedEnum {
    
    ACTIVE("ACTIV"),
    INACTIVE("INACTIVE"),
    ARCHIVED("ARCHIVED");

    private String status_;
    
    private JobProfileStatus(String status){
        this.status_ = status;
    }
    
    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return status_;
    }

}
