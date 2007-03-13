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
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioiningDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<OrderProvisioning> implements OrderProvisioningDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<OrderProvisioning> getEntityClass() {
        return OrderProvisioning.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "provisioningId";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.provisioning.OrderProvisioningDao#getOrderProvisioningByUid(java.lang.String)
     */
    public OrderProvisioning getOrderProvisioningByUid(String uid) throws EntityNotFoundException {
        return load(uid);
    }
    
    

}
