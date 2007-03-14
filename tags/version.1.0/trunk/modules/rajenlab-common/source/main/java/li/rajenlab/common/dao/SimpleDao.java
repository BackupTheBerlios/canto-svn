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
 * Extends BaseDao support with a load method for simple entities.
 * In this context simple means an entity with a simple string key.
 * It is up to the implementation of this interface as to how it establishes
 * the entity field to be used as the key.
 * This interface may be extended with specific findBy and loadBy as shown in 
 * the following example:
 * <code>
 * public interface MyDao extends SimpleDao<MyEntity> {
 *     // other methods from my specific interface MyDao
 *     public List<MyEntity> findByFirstName(String name);
 * }
 * </code>
 * @param <E> the Entity Type which is to be persisted stored loaded etc.
 *
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface SimpleDao<E> extends BaseDao<E> {
	/**
	 * load an entity <E> from the persistant store using the given key
	 * @param key the key used to lookup the entity
	 * @return the loaded entity.
	 * @throws EntityNotFoundException if no entity, or several matching entites were found
	 */
	public abstract E load(String key) throws EntityNotFoundException;
	
}
