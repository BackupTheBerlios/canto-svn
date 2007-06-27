/**
 * 
 */
package pareon.canto.framework.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author tzhrora2
 *
 */
public abstract class BaseDaoHibernateImpl<E> extends HibernateDaoSupport
		implements BaseDao<E> {

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDao#delete(java.lang.Object)
	 */
	public void delete(E e) {
		getHibernateTemplate().delete(e);
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDao#evict(java.lang.Object)
	 */
	public void evict(E e) {
		getHibernateTemplate().evict(e);
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDao#lock(java.lang.Object, boolean)
	 */
	public void lock(E e, boolean wait) {
		lock(e, wait ? LockMode.UPGRADE : LockMode.UPGRADE_NOWAIT);
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDao#refresh(java.lang.Object)
	 */
	public void refresh(E e) {
		getHibernateTemplate().refresh(e);
	}

	/* (non-Javadoc)
	 * @see pareon.canto.framework.dao.BaseDao#store(java.lang.Object)
	 */
	public void store(E e) {
		 getHibernateTemplate().persist(e);
	}

	public void lock(E e, LockMode lockMode) {
		getHibernateTemplate().lock(e, lockMode);
	}

	@SuppressWarnings ("unchecked")
	public E load(String businessKey) throws EntityNotFoundException {
		DetachedCriteria crit = getDetachedCriteria();
		crit.add(Restrictions.eq(getKeyField(), businessKey));
		List<E> results = getHibernateTemplate().findByCriteria(crit);
		
        if (results == null || results.size() == 0){
            throw new EntityNotFoundException(businessKey);
        } else if (results.size() > 1) {
            String msg = "more than one ["+results.size()+"] found : " + businessKey;
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
