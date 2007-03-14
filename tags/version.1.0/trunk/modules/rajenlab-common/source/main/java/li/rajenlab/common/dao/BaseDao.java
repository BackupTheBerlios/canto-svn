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

package li.rajenlab.common.dao;

/**
 * The basic methods which should be provided by all Dao's.
 * This interface may be extended with specific findBy and loadBy methods
 * as shown in the following example.
 * <code>
 * public interface MyDao extends BaseDao<MyEntity> {
 *     // other methods from my specific interface MyDao
 *     public List<MyEntity> findByFirstName(String name);
 * }
 * </code>
 * @param <E> the Entity Type which is to be persisted stored etc.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */

public interface BaseDao<E> {
	/**
	 * store the given entity
	 * @param e the entity to be stored
	 */
	public abstract void store (E e);
	/**
	 * delete the given entity
	 * @param e the entity to be deleted
	 */
	public abstract void delete (E e);
	/**
	 * evict the given entity
	 * @param e the entity to be evicted
	 */
	public abstract void evict (E e);
	/**
	 * lock the given entity with either lock mode UPGRADE or UPGRADE_NOWAIT
	 * @param e the entity to be deleted
	 * @param wait if true lock mode UPGRADE_NOWAIT will be used, otherwise lock mode UPGRADE will be used 
	 */
	public abstract void lock (E e, boolean wait);
	/**
	 * refresh the given entity from the persistant store.
	 * @param e the entity to be refreshed
	 */
	public abstract void refresh (E e);
}
