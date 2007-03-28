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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import li.rajenlab.canto.core.model.SimpleIdBeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity
@Table(name="SALES_STEP")
public class SalesStep extends SimpleIdBeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -6248940366972754728L;
    
    @Column(name="NAME", nullable=false,unique=true,length=100)
    private String name;
    
    @Column(name="DESCRIPTION", length=2000)
    private String description;
    
    @Column(name="PROCESS_NAME", length=50, nullable=false)
    private String processName;
    
    @OneToMany
    @JoinTable(name="SALES_STEP_PROCESS_ATTRIBUTES", joinColumns = @JoinColumn(name = "SALESSTEP_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "processAttributes_null"))
    private Map<String,Object> processAttributes;
    
    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
   
    /**
     * @return the processAttributes
     */
    public Map<String, Object> getProcessAttributes() {
        return this.processAttributes;
    }
    /**
     * @param processAttributes the processAttributes to set
     */
    public void setProcessAttributes(Map<String, Object> processAttributes) {
        this.processAttributes = processAttributes;
    }
    /**
     * @return the processName
     */
    public String getProcessName() {
        return this.processName;
    }
    /**
     * @param processName the processName to set
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
