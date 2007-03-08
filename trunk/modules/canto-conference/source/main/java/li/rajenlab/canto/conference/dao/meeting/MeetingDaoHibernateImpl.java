/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:45 $
 * $LastChangedDate:2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) $
 ******************************************************************************
 * Project: canto-meeting
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-meeting/source/main/java/li/rajenlab/canto/meeting/dao/meeting/MeetingDaoHibernateImpl.java $
 ******************************************************************************/

package li.rajenlab.canto.conference.dao.meeting;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import li.rajenlab.canto.conference.domain.meeting.Meeting;
import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;
import li.rajenlab.common.support.DateUtils;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id:MeetingDaoHibernateImpl.java 45 2007-03-07 13:24:16 +0000 (Mi, 07 Mrz 2007) neoraph $
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
  

}
