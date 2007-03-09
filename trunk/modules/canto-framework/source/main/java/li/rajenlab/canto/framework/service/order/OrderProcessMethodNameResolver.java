/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.order;

import li.rajenlab.canto.framework.domain.order.OrderType;
import li.rajenlab.canto.framework.service.order.exceptions.NoProcessMethodFoundException;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProcessMethodNameResolver {
    
    
    /**
     * Resolve Process Method Name
     * @param orderType
     * @return
     */
    public String resolveProcessMethodName(OrderType orderType)
        throws NoProcessMethodFoundException;

}
