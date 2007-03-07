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
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class CateringOrderDaoHibernateImpl extends
        AbstractSimpleDaoHibernateImpl<CateringOrder> implements CateringOrderDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<CateringOrder> getEntityClass() {
        return CateringOrder.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "orderId";
    }

    /**
     * @see li.rajenlab.canto.core.dao.catering.CateringOrderDao#getCateringOrderById(java.lang.String)
     */
    public CateringOrder getCateringOrderById(String orderId)
            throws EntityNotFoundException {
        return load(orderId);
    }

}
