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

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import li.rajenlab.canto.core.domain.catering.Catering;
import li.rajenlab.canto.core.domain.catering.CateringType;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class CateringDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Catering>
        implements CateringDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Catering> getEntityClass() {
        return Catering.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

    /**
     * @see li.rajenlab.canto.core.dao.catering.CateringDao#getCateringsByType(li.rajenlab.canto.core.domain.catering.CateringType)
     */
    @SuppressWarnings("unchecked")
    public List<Catering> getCateringsByType(CateringType type) {
        DetachedCriteria detachedCriteria = getDetachedCriteria();
        
        if (type!=null){
            detachedCriteria.add(Restrictions.eq("type",type));
        }
        
        detachedCriteria.addOrder(Order.asc("type"));
        detachedCriteria.addOrder(Order.asc("price"));
        
        return this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }

  

}
