/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.meeting.dao.meeting;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.canto.meeting.domain.meeting.Meeting;
import li.rajenlab.canto.meeting.domain.room.Room;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;
import li.rajenlab.common.support.DateUtils;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class MeetingDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Meeting>
        implements MeetingDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Meeting> getEntityClass() {
        return Meeting.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "meetingId";
    }

    /**
     * @see li.rajenlab.canto.meeting.dao.meeting.MeetingDao#getRunningMeetings()
     */
    @SuppressWarnings("unchecked")
    public List<Meeting> getRunningMeetings() {
        DetachedCriteria detachedCriteria = getDetachedCriteria();
        
        Calendar today = Calendar.getInstance();
        detachedCriteria.add(Restrictions.ge("startDate",DateUtils.normalizeDateFrom(today.getTime())));
        detachedCriteria.add(Restrictions.lt("endDate",DateUtils.normalizeDateTo(today.getTime())));
       
        return getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    /**
     * @see li.rajenlab.canto.meeting.dao.meeting.MeetingDao#searchMeetingsByOrganizer(li.rajenlab.canto.core.domain.organizer.Organizer)
     */
    @SuppressWarnings("unchecked")
    public List<Meeting> searchMeetingsByOrganizer(Organizer organizer) {
        if (organizer!=null){
            DetachedCriteria detachedCriteria = getDetachedCriteria();
            
            detachedCriteria.setFetchMode("organizer", FetchMode.JOIN);
            detachedCriteria.add(Restrictions.eq("organizer",organizer));
            detachedCriteria.addOrder(Order.asc("startDate"));
            detachedCriteria.addOrder(Order.asc("endDate"));
           
            return getHibernateTemplate().findByCriteria(detachedCriteria);
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * @see li.rajenlab.canto.meeting.dao.meeting.MeetingDao#searchMeetingsByRoom(li.rajenlab.canto.meeting.domain.room.Room)
     */
    @SuppressWarnings("unchecked")
    public List<Meeting> searchMeetingsByRoom(Room room) {
        
        if (room!=null){
            DetachedCriteria detachedCriteria = getDetachedCriteria();
            
            detachedCriteria.setFetchMode("room", FetchMode.JOIN);
            detachedCriteria.add(Restrictions.eq("room",room));
            detachedCriteria.addOrder(Order.asc("startDate"));
            detachedCriteria.addOrder(Order.asc("endDate"));
            
            return getHibernateTemplate().findByCriteria(detachedCriteria);
        } else {
            return Collections.emptyList();
        }
        
        
    }
  

}
