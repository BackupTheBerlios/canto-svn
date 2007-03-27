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
import javax.persistence.Column;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
@Entity(name="DocumentType")
@DiscriminatorValue("DocumentType")
public class DocumentType extends EnumEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8166202527164160395L;
    @Column(name="DOC_TYPE_CONTENT_TYPE")
    private String contentType_;

    /**
     * @return the contentType
     */
    public String getContentType() {
        return this.contentType_;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType_ = contentType;
    }
    
    

}
