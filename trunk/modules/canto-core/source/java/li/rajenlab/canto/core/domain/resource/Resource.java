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

package li.rajenlab.canto.core.domain.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import li.rajenlab.common.domain.AbstractEntity;

import org.springframework.util.StringUtils;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class Resource extends AbstractEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1590641664422491764L;

    private String name_;
    private String description_;
    private String code_;  // unique
    private ResourceType resourceType_;
    private Map<String,String>   settings_;
    
    
    /**
     * Adds Settings to the Resource.
     * 
     * @param name the name of the Settings.
     * @param value the value of the Settings.
     */
    public synchronized void addSettings( String name, String value ) {
        if ( getSettings() == null ) {
            setSettings( new HashMap<String,String>() );
        }
        getSettings().put(name,value);
    }
    
    /**
     * Adds Settings to the Resource but only if the Settings is not set already.
     * 
     * @param name the name of the Settings.
     * @param value the value of the Settings.
     */
    public synchronized void addSettingsIfMissing( String name, String value ) {
        if ( getSettings() == null ) {
            setSettings( new HashMap<String,String>() );
        }
        if ( getSettingsValue(name) != null && !StringUtils.hasText(getSettingsValue(name))) {
            getSettings().put(name,value);
        }
    }
    
    /**
     * Adds Settings to the Resource. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the metadata.
     * @param value the value of the metadata.
     */
    public synchronized void mergeSettingsTokenized( String name, String value, String token ) {
        if ( getSettings() == null ) {
            setSettings( new HashMap<String,String>() );
        }
        String metaDataValue = getSettingsValue(name);
        if (StringUtils.hasText(metaDataValue)) {
            StringTokenizer st = new StringTokenizer(metaDataValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            metaDataValue = metaDataValue + token + value;

        } else {
            // metadata value not set before
            metaDataValue = value;
        }
        getSettings().put(name,StringUtils.trimAllWhitespace(metaDataValue));
        
    }
    
    /**
     * Gets Settings value from the Resource of a certain key.
     * 
     * @param name the name of the Settings.
     */
    public synchronized String getSettingsValue (String name) {
        return (getSettings() != null ? getSettings().get(name) : null);
    }

    /**
     * Removes Settings from the Resource.
     * 
     * @param name the name of the Settings.
     */
    public synchronized void removeSettings( String name ) {
        if ( getSettings() != null ) {
            getSettings().remove(name);
        }
    }
    
    /**
     * @return the resourceType
     */
    public ResourceType getResourceType() {
        return this.resourceType_;
    }

    /**
     * @param resourceType the resourceType to set
     */
    public void setResourceType(ResourceType resourceType) {
        this.resourceType_ = resourceType;
    }

    /**
     * @return the resourceSettings
     */
    public Map<String, String> getSettings() {
        return this.settings_;
    }

    /**
     * @param resourceSettings the resourceSettings to set
     */
    public void setSettings(Map<String, String> resourceSettings) {
        this.settings_ = resourceSettings;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code_;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code_ = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description_;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description_ = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    
    
    
    
}
