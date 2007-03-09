/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.order;

import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Order>
        implements OrderDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "orderId";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.order.OrderDao#getOrderByOrderId(java.lang.String)
     */
    public Order getOrderByOrderId(String orderId)
            throws EntityNotFoundException {
        return load(orderId);
    }

   
}
