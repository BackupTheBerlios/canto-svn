/**
 * 
 */
package pareon.canto.framework.dao;

import org.hibernate.LockMode;

/**
 * @author tzhrora2
 *
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
	
	
	public abstract void lock(E e, LockMode lockMode);
	
	/**
	 * refresh the given entity from the persistant store.
	 * @param e the entity to be refreshed
	 */
	public abstract void refresh (E e);
	
	/**
	 * load an entity <E> from the persistant store using the given key
	 * @param key the key used to lookup the entity
	 * @return the loaded entity.
	 * @throws EntityNotFoundException if no entity, or several matching entites were found
	 */
	public abstract E load(String key) throws EntityNotFoundException;
	
}
