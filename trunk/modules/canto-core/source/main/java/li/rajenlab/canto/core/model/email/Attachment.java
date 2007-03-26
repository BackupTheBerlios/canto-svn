/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.email;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.document.Document;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Attachment extends Entity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -7975487266290414365L;
    private String objectId_;
    private Document document_;
    private boolean inlined_;
    /**
     * @return the document
     */
    public Document getDocument() {
        return this.document_;
    }
    /**
     * @param document the document to set
     */
    public void setDocument(Document document) {
        this.document_ = document;
    }
    /**
     * @return the inlined
     */
    public boolean isInlined() {
        return this.inlined_;
    }
    /**
     * @param inlined the inlined to set
     */
    public void setInlined(boolean inlined) {
        this.inlined_ = inlined;
    }
    /**
     * @return the objectId
     */
    public String getObjectId() {
        return this.objectId_;
    }
    /**
     * @param objectId the objectId to set
     */
    public void setObjectId(String objectId) {
        this.objectId_ = objectId;
    }
    
    

}
