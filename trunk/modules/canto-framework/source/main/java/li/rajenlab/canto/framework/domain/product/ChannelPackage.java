/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.product;

import java.util.HashSet;
import java.util.Set;

import li.rajenlab.canto.framework.domain.channel.Channel;
import li.rajenlab.canto.framework.domain.common.Language;
import li.rajenlab.common.domain.AbstractEntity;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ChannelPackage extends AbstractEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -104283843883480389L;
    
    private String uid_;
    private String packageName_;
    private Set<Channel> channels_;
    private ChannelPackageType channelPackageType_;
    private Language channelPackageLanguage_; // only usefull when all the language of the channels are identical
    private ChannelPackageStatus channelPackageStatus_;
    
    /**
     * @return the packageName
     */
    public String getPackageName() {
        return this.packageName_;
    }
    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName_ = packageName;
    }
   
   
    /**
     * @return the channels
     */
    public Set<Channel> getChannels() {
        return this.channels_;
    }
    /**
     * @param channels the channels to set
     */
    public void setChannels(Set<Channel> channels) {
        this.channels_ = channels;
    }
    
    public synchronized void addChannel(Channel channel){
        if (getChannels()==null){
            channels_ = new HashSet<Channel>();
        }
        
        channels_.add(channel);
    }
    
    public synchronized void removeChannel(Channel channel){
        if (getChannels()!=null){
            channels_.remove(channel);
        }
    }
    
   
    /**
     * @return the channelPackageType
     */
    public ChannelPackageType getChannelPackageType() {
        return this.channelPackageType_;
    }
    /**
     * @param channelPackageType the channelPackageType to set
     */
    public void setChannelPackageType(ChannelPackageType channelPackageType) {
        this.channelPackageType_ = channelPackageType;
    }
    /**
     * @return the channelPackageLanguage
     */
    public Language getChannelPackageLanguage() {
        return this.channelPackageLanguage_;
    }
    /**
     * @param channelPackageLanguage the channelPackageLanguage to set
     */
    public void setChannelPackageLanguage(Language channelPackageLanguage) {
        this.channelPackageLanguage_ = channelPackageLanguage;
    }
    /**
     * @return the uid
     */
    public String getUid() {
        return this.uid_;
    }
    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid_ = uid;
    }
    /**
     * @return the channelPackageStatus
     */
    public ChannelPackageStatus getChannelPackageStatus() {
        return this.channelPackageStatus_;
    }
    /**
     * @param channelPackageStatus the channelPackageStatus to set
     */
    public void setChannelPackageStatus(ChannelPackageStatus channelPackageStatus) {
        this.channelPackageStatus_ = channelPackageStatus;
    }
    

}
