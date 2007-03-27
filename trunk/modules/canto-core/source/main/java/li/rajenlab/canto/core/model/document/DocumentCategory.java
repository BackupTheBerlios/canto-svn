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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import li.rajenlab.canto.core.model.EnumEntity;
import javax.persistence.Basic;
import javax.persistence.Column;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="DocumentType")
@DiscriminatorValue("DocumentType")
public class DocumentCategory extends EnumEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1828763480337772120L;
    @Basic
    @Column(name="DOC_CATEGORY_PARENT")
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
