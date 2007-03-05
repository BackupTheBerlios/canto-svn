/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.domain.module;

import java.util.Map;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Module extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8661617554714140412L;
    
    private String name_;
    private Map<String, Control> controls_;

    
    public Control getControl( String name ) {
        if ( name == null ) {
            return null;
        }
        if ( getControls() != null ) {
            return getControls().get(name);
        }
        return null;
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
     * @return Returns the controls.
     */
    public Map<String, Control> getControls() {
        return controls_;
    }

    /**
     * @param controls The controls to set.
     */
    public void setControls(Map<String, Control> controls) {
        this.controls_ = controls;
    }
    
    

}
