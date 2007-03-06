/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.hibernate;

import java.util.List;

import li.rajenlab.common.dao.EntityNotFoundException;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Hibernate specific implementation of SimpleDao.
 * Uses and extends {@link HibernateDaoSupport}.
 * This class is designed to be extended for a specific entity,
 * which then implements the abstract methods.
 * 
 * Example:
 * <code>
 * class MyDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<MyEntity> implements MyDao {
 *     // concrete implementation of abstract methods
 *     public String getKeyField() {
 *         return "MY_KEY";
 *     }
 *     public abstract Class<E> getEntityClass() {
 *         return MyEntity.class;
 *     }
 *     // other methods from my specific interface MyDao
 *     public List<MyEntity> findByFirstName(String name) {
 *         // not shown ...
 *     }
 * }
 * </code>
 * 
 * As shwon the exetended interface can also provide other dao specific find methods etc.
 * 
 * @param <E> the Entity Type which is to be persisted stored etc.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public abstract class AbstractSimpleDaoHibernateImpl<E> extends BaseDaoHibernateImpl<E> {

	@SuppressWarnings ("unchecked")
	public E load(String businessKey) throws EntityNotFoundException {
		DetachedCriteria crit = getDetachedCriteria();
		crit.add(Restrictions.eq(getKeyField(), businessKey));
		List<E> results = getHibernateTemplate().findByCriteria(crit);
		
        if (results == null || results.size() == 0){
            throw new EntityNotFoundException(businessKey);
        } else if (results.size() > 1) {
            String msg = "more than one ["+results.size()+"] found : " + businessKey;
            //log.warn(msg);
            throw new EntityNotFoundException(msg);
        }
        return results.get(0);
	}

	protected DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(getEntityClass());
	}
	
	public abstract String getKeyField();
	public abstract Class<E> getEntityClass();
	
}
