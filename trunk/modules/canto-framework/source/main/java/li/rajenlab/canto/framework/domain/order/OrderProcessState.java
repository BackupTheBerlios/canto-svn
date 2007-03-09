/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import li.rajenlab.common.lang.StringValuedEnum;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public enum OrderProcessState implements StringValuedEnum {
    
    INITIAL("INITIAL"),
    FAILED("FAILED"),
    FINAL("FINAL");
    
    private String processState_;
    
    private OrderProcessState(String processState){
        this.processState_ = processState;
    }

    /**
     * @see li.rajenlab.common.lang.StringValuedEnum#getValue()
     */
    public String getValue() {
        return processState_;
    }

}
