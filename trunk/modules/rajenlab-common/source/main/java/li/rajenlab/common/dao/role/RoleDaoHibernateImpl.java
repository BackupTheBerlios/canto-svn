/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.dao.role;

import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;
import li.rajenlab.common.domain.security.Role;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class RoleDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Role>
        implements RoleDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Role> getEntityClass() {
        return Role.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "id";
    }

}
