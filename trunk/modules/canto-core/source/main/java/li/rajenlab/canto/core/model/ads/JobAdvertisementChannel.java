/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.ads;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class JobAdvertisementChannel implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5158929064919975515L;
    private String id_;
    private String channelName_;
    /**
     * @return the channelName
     */
    public String getChannelName() {
        return this.channelName_;
    }
    /**
     * @param channelName the channelName to set
     */
    public void setChannelName(String channelName) {
        this.channelName_ = channelName;
    }
    /**
     * @return the id
     */
    public String getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id_ = id;
    }
    
    

}
