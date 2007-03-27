/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.document;

import li.rajenlab.canto.core.model.EnumEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DocumentCategory extends EnumEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1828763480337772120L;
    private DocumentCategory parent_;

    /**
     * @return the parent
     */
    public DocumentCategory getParent() {
        return this.parent_;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(DocumentCategory parent) {
        this.parent_ = parent;
    }
    
    

}
