/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.dao.participant;

import li.rajenlab.canto.core.domain.participant.Participant;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class ParticipantDaoHibernateImpl 
       extends AbstractSimpleDaoHibernateImpl<Participant>
        implements ParticipantDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Participant> getEntityClass() {
        return Participant.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "participantId";
    }

}
