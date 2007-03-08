/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-conference
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.conference.dao.room;

import li.rajenlab.canto.conference.domain.room.Room;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class RoomDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Room>
        implements RoomDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Room> getEntityClass() {
        return Room.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "code";
    }

}
