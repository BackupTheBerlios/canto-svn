/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.provisioning;

import li.rajenlab.canto.framework.domain.provisioning.OrderProvisioning;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProvisioningDao extends SimpleDao<OrderProvisioning> {
    
    
    public OrderProvisioning getOrderProvisioningByUid(String uid)
        throws EntityNotFoundException;

}
