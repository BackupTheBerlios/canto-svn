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

import li.rajenlab.common.dao.BaseDao;

import org.hibernate.LockMode;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Hibernate specific implementation of BaseDao.
 * Uses and extends {@link HibernateDaoSupport}.
 * 
 * Although this is a concrete class and it is possible to use this class directly
 * it is not intended to be used as such except for very simple cases and test cases
 * where a concrete Dao implementation is not required.
 * Instead this class is designed to be extended for a specific entity as 
 * shown in the following Example:
 * 
 * <code>
 * class MyDaoHibernateImpl extends BaseDaoHibernateImpl<MyEntity> implements MyDao {
 *     // other methods from my specific interface MyDao
 *     public List<MyEntity> findByFirstName(String name) {
 *         // not shown ...
 *     }
 * }
 * </code>
 * @param <E> the Entity Type which is to be persisted stored etc.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class BaseDaoHibernateImpl<E> extends HibernateDaoSupport implements BaseDao<E> {

	// see interface definition
	public void delete(E e) {
		getHibernateTemplate().delete(e);
	}

	// see interface definition
	public void evict(E e) {
		getHibernateTemplate().evict(e);
	}

	// see interface definition
	public void store(E e) {
        getHibernateTemplate().persist(e);
	}

	// see interface definition
	public void refresh(E e) {
		getHibernateTemplate().refresh(e);
	}
	
	// see interface definition
	public void lock(E e, boolean wait) {
		lock(e, wait ? LockMode.UPGRADE : LockMode.UPGRADE_NOWAIT);
	}

	// see interface definition
	public void lock(E e, LockMode lockMode) {
		getHibernateTemplate().lock(e, lockMode);
	}
}
