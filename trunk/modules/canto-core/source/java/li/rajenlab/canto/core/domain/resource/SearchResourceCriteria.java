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

import java.io.Serializable;
import java.util.Map;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class SearchResourceCriteria implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3408576704290263012L;
    
    
    private ResourceType resourceType_;
    private String code_;
    private Map<String,String> settings_;
    
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
    
    
    

}
