/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.jpa;

import li.rajenlab.common.dao.BaseDao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * Jpa specific implementation of BaseDao.
 * Uses and extends {@link HibernateDaoSupport}.
 * 
 * Although this is a concrete class and it is possible to use this class directly
 * it is not intended to be used as such except for very simple cases and test cases
 * where a concrete Dao implementation is not required.
 * Instead this class is designed to be extended for a specific entity as 
 * shown in the following Example:
 * 
 * <code>
 * class MyDaoJpaImpl extends BaseDaoJpaImpl<MyEntity> implements MyDao {
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
 * @param <E>
 */
public class BaseDaoJpaImpl<E> extends JpaDaoSupport implements BaseDao<E> {

    /**
     * @see li.rajenlab.common.dao.BaseDao#delete(java.lang.Object)
     */
    public void delete(Object e) {
        getJpaTemplate().remove(e);
    }

    /**
     * @see li.rajenlab.common.dao.BaseDao#evict(java.lang.Object)
     */
    public void evict(Object e) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see li.rajenlab.common.dao.BaseDao#lock(java.lang.Object, boolean)
     */
    public void lock(Object e, boolean wait) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see li.rajenlab.common.dao.BaseDao#refresh(java.lang.Object)
     */
    public void refresh(Object e) {
        getJpaTemplate().refresh(e);
    }

    /**
     * @see li.rajenlab.common.dao.BaseDao#store(java.lang.Object)
     */
    public void store(Object e) {
       getJpaTemplate().persist(e);
    }

}
