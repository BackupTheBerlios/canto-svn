/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.channel;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

import li.rajenlab.canto.framework.domain.common.Language;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Channel extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -4901288577650121369L;
    
    private String channelName_;
    private String channelDescription_;
    private String channelLogoUrl_;
    private ChannelMedia channelMedia_;
    private Language channelLanguage_;
    private String channelId_;
    private Map<String,String> channelAttributes_;
    private ChannelStatus channelStatus_;
    
    /**
     * @return the channelDescription
     */
    public String getChannelDescription() {
        return this.channelDescription_;
    }
    /**
     * @param channelDescription the channelDescription to set
     */
    public void setChannelDescription(String channelDescription) {
        this.channelDescription_ = channelDescription;
    }
    /**
     * @return the channelLogoUrl
     */
    public String getChannelLogoUrl() {
        return this.channelLogoUrl_;
    }
    /**
     * @param channelLogoUrl the channelLogoUrl to set
     */
    public void setChannelLogoUrl(String channelLogoUrl) {
        this.channelLogoUrl_ = channelLogoUrl;
    }
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
     * @return the channelLanguage
     */
    public Language getChannelLanguage() {
        return this.channelLanguage_;
    }
    /**
     * @param channelLanguage the channelLanguage to set
     */
    public void setChannelLanguage(Language channelLanguage) {
        this.channelLanguage_ = channelLanguage;
    }
    /**
     * @return the channelMedia
     */
    public ChannelMedia getChannelMedia() {
        return this.channelMedia_;
    }
    /**
     * @param channelMedia the channelMedia to set
     */
    public void setChannelMedia(ChannelMedia channelMedia) {
        this.channelMedia_ = channelMedia;
    }
    /**
     * @return the channelId
     */
    public String getChannelId() {
        return this.channelId_;
    }
    /**
     * @param channelId the channelId to set
     */
    public void setChannelId(String channelId) {
        this.channelId_ = channelId;
    }
    /**
     * @return the channelAttributes
     */
    public Map<String, String> getChannelAttributes() {
        return this.channelAttributes_;
    }
    /**
     * @param channelAttributes the channelAttributes to set
     */
    public void setChannelAttributes(Map<String, String> channelAttributes) {
        this.channelAttributes_ = channelAttributes;
    }
    
    
    /**
     * Deep copy all attributes to the other instance.
     */
    public void copyTo( Channel to ) {
        
        to.setChannelId(this.getChannelId());
        to.setChannelDescription(this.getChannelDescription());
        to.setChannelLanguage(this.getChannelLanguage());
        to.setChannelLogoUrl(this.getChannelLogoUrl());
        to.setChannelMedia(this.getChannelMedia());
        to.setChannelName(this.getChannelName());
        
        Map<String,String> channelAttributes = new HashMap<String,String>();
        if ( this.getChannelAttributes() != null ) {
            channelAttributes.putAll(this.getChannelAttributes());
            to.setChannelAttributes(channelAttributes);
        }
    }

    /**
     * Adds channelAttributes to the Channel.
     * 
     * @param name the name of the channelAttributes.
     * @param value the value of the channelAttributes.
     */
    public synchronized void addChannelAttribute( String name, String value ) {
        if ( getChannelAttributes() == null ) {
            setChannelAttributes( new HashMap<String,String>() );
        }
        getChannelAttributes().put(name,value);
    }
    
    /**
     * Adds channelAttributes to the Channel but only if the channelAttributes is not set already.
     * 
     * @param name the name of the channelAttributes.
     * @param value the value of the channelAttributes.
     */
    public synchronized void addChannelAttributeIfMissing( String name, String value ) {
        if ( getChannelAttributes() == null ) {
            setChannelAttributes( new HashMap<String,String>() );
        }
        if ( getChannelAttributeValue(name) != null && 
                            !StringUtils.hasText(getChannelAttributeValue(name))) {
            getChannelAttributes().put(name,value);
        }
    }
    
    /**
     * Adds channelAttributes to the Channel. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the channelAttributes.
     * @param value the value of the channelAttributes.
     */
    public synchronized void mergeChannelAttributeTokenized( String name, String value, String token ) {
        if ( getChannelAttributes() == null ) {
            setChannelAttributes( new HashMap<String,String>() );
        }
        String channelAttributeValue = getChannelAttributeValue(name);
        if (StringUtils.hasText(channelAttributeValue)) {
            StringTokenizer st = new StringTokenizer(channelAttributeValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            channelAttributeValue = channelAttributeValue + token + value;

        } else {
            // metadata value not set before
            channelAttributeValue = value;
        }
        getChannelAttributes().put(name,StringUtils.trimAllWhitespace(channelAttributeValue));
        
    }
    
    /**
     * Gets channelAttributes value from the Channel of a certain key.
     * 
     * @param name the name of the channelAttributes.
     */
    public synchronized String getChannelAttributeValue (String name) {
        return (getChannelAttributes() != null ? getChannelAttributes().get(name) : null);
    }

    /**
     * Removes channelAttributes from the Channel.
     * 
     * @param name the name of the channelAttributes.
     */
    public synchronized void removeChannelAttribute( String name ) {
        if ( getChannelAttributes() != null ) {
            getChannelAttributes().remove(name);
        }
    }
    /**
     * @return the channelStatus
     */
    public ChannelStatus getChannelStatus() {
        return this.channelStatus_;
    }
    /**
     * @param channelStatus the channelStatus to set
     */
    public void setChannelStatus(ChannelStatus channelStatus) {
        this.channelStatus_ = channelStatus;
    }
    
    

}
