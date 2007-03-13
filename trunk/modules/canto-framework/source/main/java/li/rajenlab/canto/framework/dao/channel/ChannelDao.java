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
import li.rajenlab.common.dao.SimpleDao;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ChannelDao extends SimpleDao<Channel> {
    
    /**
     * Get channel by uid
     * @param uid
     * @return
     * @throws EntityNotFoundException
     */
    public Channel getChannelByUid(String uid) throws EntityNotFoundException;
    
    /**
     * Get list of channel by media
     * @param channelMedia
     * @return
     */
    public List<Channel> getChannelByMedia(ChannelMedia channelMedia);
    
    /**
     * Get list of channel by status
     * @param channelStatus
     * @return
     */
    public List<Channel> getChannelByStatus(ChannelStatus channelStatus);
    
   /**
    * Search channel
    * @param uid
    * @param name
    * @param channelStatus
    * @param channelMedia
    * @return
    */
    public List<Channel> searchChannel(
            String uid, String name, ChannelStatus channelStatus, ChannelMedia channelMedia);
    
    

}
