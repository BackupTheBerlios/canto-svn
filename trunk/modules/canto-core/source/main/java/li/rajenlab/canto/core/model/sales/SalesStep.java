/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.sales;

import java.util.Map;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SalesStep extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6248940366972754728L;
    private String name_;
    private String description_;
    private String processName_;
    private Map<String,Object> processAttributes_;
    
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
    @Override
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the processAttributes
     */
    public Map<String, Object> getProcessAttributes() {
        return this.processAttributes_;
    }
    /**
     * @param processAttributes the processAttributes to set
     */
    public void setProcessAttributes(Map<String, Object> processAttributes) {
        this.processAttributes_ = processAttributes;
    }
    /**
     * @return the processName
     */
    public String getProcessName() {
        return this.processName_;
    }
    /**
     * @param processName the processName to set
     */
    public void setProcessName(String processName) {
        this.processName_ = processName;
    }
    
    
    
    
    
}
