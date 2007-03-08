/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:43 $
 * $LastChangedDate:2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/canto-core/source/main/java/li/rajenlab/canto/core/domain/AbstractEventEntity.java $
 ******************************************************************************/

package li.rajenlab.canto.core.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import li.rajenlab.canto.core.domain.organizer.Organizer;
import li.rajenlab.common.domain.AbstractEntity;

import org.springframework.util.StringUtils;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id:AbstractEventEntity.java 43 2007-03-07 13:22:46 +0000 (Mi, 07 Mrz 2007) neoraph $
 *
 *  <map name="settings" table="CANTO_EVENT_SETTINGS">
        <key column="EVENT_CODE"/>
        <map-key column="SETTINGS_NAME" type="string"/>
        <element column="SETTINGS_VALUE" type="string" length="2000"/>
    </map>  
 *
 */
public abstract class AbstractEventEntity extends AbstractEntity {
    
    
    private String code_;
    private String title_;
    private String description_;
    private Organizer organizer_;
    private Map<String,String>   settings_;
    private Date startDate_;
    private Date endDate_;  
    private Date reminderDate_;
    
    
    
    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate_;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate_ = endDate;
    }
    
    /**
     * @return the organizer
     */
    public Organizer getOrganizer() {
        return this.organizer_;
    }
    /**
     * @param organizer the organizer to set
     */
    public void setOrganizer(Organizer organizer) {
        this.organizer_ = organizer;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate_;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate_ = startDate;
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
     * @return the title
     */
    public String getTitle() {
        return this.title_;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title_ = title;
    }
    /**
     * @return the reminderDate
     */
    public Date getReminderDate() {
        return this.reminderDate_;
    }
    /**
     * @param reminderDate the reminderDate to set
     */
    public void setReminderDate(Date reminderDate) {
        this.reminderDate_ = reminderDate;
    }

    /**
     * Adds Settings to the Event.
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
     * Adds Settings to the Event but only if the Settings is not set already.
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
     * Adds Settings to the Event. If the value is already set, the new value is appended 
     * to the current value (separated by a comma).
     * 
     * @param name the name of the metadata.
     * @param value the value of the metadata.
     */
    public synchronized void mergeSettingsTokenized( String name, String value, String token ) {
        if ( getSettings() == null ) {
            setSettings( new HashMap<String,String>() );
        }
        String settingsValue = getSettingsValue(name);
        if (StringUtils.hasText(settingsValue)) {
            StringTokenizer st = new StringTokenizer(settingsValue, token);
            
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals(value)){
                    // not necessary to add a value twice
                    return;
                }
            }

            // value not present but other content -> append value
            settingsValue = settingsValue + token + value;

        } else {
            // metadata value not set before
            settingsValue = value;
        }
        getSettings().put(name,StringUtils.trimAllWhitespace(settingsValue));
        
    }
    
    /**
     * Gets Settings value from the Event of a certain key.
     * 
     * @param name the name of the Settings.
     */
    public synchronized String getSettingsValue (String name) {
        return (getSettings() != null ? getSettings().get(name) : null);
    }

    /**
     * Removes Settings from the Event.
     * 
     * @param name the name of the Settings.
     */
    public synchronized void removeSettings( String name ) {
        if ( getSettings() != null ) {
            getSettings().remove(name);
        }
    }
    /**
     * @return the settings
     */
    public Map<String, String> getSettings() {
        return this.settings_;
    }
    /**
     * @param settings the settings to set
     */
    public void setSettings(Map<String, String> settings) {
        this.settings_ = settings;
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
    
    
}
