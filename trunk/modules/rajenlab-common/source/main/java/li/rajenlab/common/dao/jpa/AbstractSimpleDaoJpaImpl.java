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

import li.rajenlab.common.dao.EntityNotFoundException;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Jpa specific implementation of SimpleDao.
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
public abstract class AbstractSimpleDaoJpaImpl<E> extends BaseDaoJpaImpl<E> {

   
    @SuppressWarnings ("unchecked")
    public E load(final String businessKey) throws EntityNotFoundException {
        
        Object object = getJpaTemplate().find(getEntityClass(), getKeyField());
        if (object==null){
            throw new EntityNotFoundException("No Entity found for key " + businessKey);
        }
        return (E)object;
    }
    
    /**
     * KeyFIeld
     * @return
     */
    public abstract String getKeyField();
    
    /**
     * Entity Class
     * @return
     */
    public abstract Class<E> getEntityClass();

}
