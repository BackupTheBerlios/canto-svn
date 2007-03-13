/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.dao.channel;

import java.util.List;

import li.rajenlab.canto.framework.domain.channel.Channel;
import li.rajenlab.canto.framework.domain.channel.ChannelMedia;
import li.rajenlab.canto.framework.domain.channel.ChannelStatus;
import li.rajenlab.common.dao.EntityNotFoundException;
import li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ChannelDaoHibernateImpl extends AbstractSimpleDaoHibernateImpl<Channel>
        implements ChannelDao {

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getEntityClass()
     */
    @Override
    public Class<Channel> getEntityClass() {
        return Channel.class;
    }

    /**
     * @see li.rajenlab.common.dao.hibernate.AbstractSimpleDaoHibernateImpl#getKeyField()
     */
    @Override
    public String getKeyField() {
        return "channelId";
    }

    /**
     * @see li.rajenlab.canto.framework.dao.channel.ChannelDao#getChannelByMedia(li.rajenlab.canto.framework.domain.channel.ChannelMedia)
     */
    @SuppressWarnings("unchecked")
    public List<Channel> getChannelByMedia(ChannelMedia channelMedia) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("channelMedia",channelMedia));
        
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.channel.ChannelDao#getChannelByStatus(li.rajenlab.canto.framework.domain.channel.ChannelStatus)
     */
    @SuppressWarnings("unchecked")
    public List<Channel> getChannelByStatus(ChannelStatus channelStatus) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        criteria.add(Restrictions.eq("channelStatus",channelStatus));
        
        return getHibernateTemplate().findByCriteria(criteria);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.channel.ChannelDao#getChannelByUid(java.lang.String)
     */
    public Channel getChannelByUid(String uid) throws EntityNotFoundException {
        return load(uid);
    }

    /**
     * @see li.rajenlab.canto.framework.dao.channel.ChannelDao#searchChannel(java.lang.String, java.lang.String, li.rajenlab.canto.framework.domain.channel.ChannelStatus, li.rajenlab.canto.framework.domain.channel.ChannelMedia)
     */
    @SuppressWarnings("unchecked")
    public List<Channel> searchChannel(String uid, String name,
            ChannelStatus channelStatus, ChannelMedia channelMedia) {
        
        DetachedCriteria criteria = getDetachedCriteria();
        
        if (StringUtils.hasText(uid)){
            criteria.add(Restrictions.eq("uid",uid));
        }
        if (StringUtils.hasLength(name)){
            criteria.add(Restrictions.ilike("channelName", name, MatchMode.ANYWHERE));
        }
        if (channelStatus !=null){
            criteria.add(Restrictions.eq("channelStatus",channelStatus));
        }
        if (channelMedia !=null){
            criteria.add(Restrictions.eq("channelMedia",channelMedia));
        }
        
        return getHibernateTemplate().findByCriteria(criteria);
    }

}
