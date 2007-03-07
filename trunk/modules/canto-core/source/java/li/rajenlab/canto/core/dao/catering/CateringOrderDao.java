/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.catering;

import li.rajenlab.canto.core.domain.catering.CateringOrder;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface CateringOrderDao extends SimpleDao<CateringOrder> {
    
    /**
     * Get catering order by order id
     * @param orderId
     * @return
     * @throws EntityNotFoundException
     */
    public CateringOrder getCateringOrderById(String orderId)
        throws EntityNotFoundException;

}
