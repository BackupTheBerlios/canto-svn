/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document.template;

import java.io.Serializable;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class TemplateCategory implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3088304176155607543L;
    private String id_;
    private String name_;
    private TemplateCategory parent_;
    
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
     * @return the parent
     */
    public TemplateCategory getParent() {
        return this.parent_;
    }
    /**
     * @param parent the parent to set
     */
    public void setParent(TemplateCategory parent) {
        this.parent_ = parent;
    }
    
    
    

}
