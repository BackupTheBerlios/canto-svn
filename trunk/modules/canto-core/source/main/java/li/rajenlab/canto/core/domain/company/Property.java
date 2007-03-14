/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.company;

import li.rajenlab.canto.core.domain.employee.Employee;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Property extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8026599690728812455L;
    private String name_;
    private String description_;
    private String code_;
    private Employee responsible_;
    
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
    /**
     * @return the responsible
     */
    public Employee getResponsible() {
        return this.responsible_;
    }
    /**
     * @param responsible the responsible to set
     */
    public void setResponsible(Employee responsible) {
        this.responsible_ = responsible;
    }

    
}
