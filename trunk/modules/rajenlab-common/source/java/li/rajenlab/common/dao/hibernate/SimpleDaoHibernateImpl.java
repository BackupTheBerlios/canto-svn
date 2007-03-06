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

/**
 * A concrete generics class implementing AbstractSimpleDaoHibernateImpl.
 * The entityClass and keyField are provided at constuction time.
 * This class is only for use in simple cases and test cases, for a specific
 * Dao implementation it is preferable that the Dao extends AbstractSimpleDaoHibernateImpl<E>
 * directly. See example in {@link AbstractSimpleDaoHibernateImpl}
 * 
 * @param <E> the Entity Type which is to be persisted stored loaded etc.
 * 
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class SimpleDaoHibernateImpl<E> extends AbstractSimpleDaoHibernateImpl<E> {

	private Class<E> entityClass_;
	private String keyField_;
	
	public SimpleDaoHibernateImpl(Class<E> entityClass, String keyField) {
        entityClass_ = entityClass;
        keyField_ = keyField;
	}
	
	@Override
	public Class<E> getEntityClass() {
		return entityClass_;
	}

	@Override
	public String getKeyField() {
		return keyField_;
	}

}
