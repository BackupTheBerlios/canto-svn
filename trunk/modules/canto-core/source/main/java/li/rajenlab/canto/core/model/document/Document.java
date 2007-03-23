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

import java.io.Serializable;
import java.util.Date;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Document implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4643343571577422167L;
    private String documentId_;
    private Date documentDate_;
    private byte[] document_;
    private String documentReferenceFileResource_;
    
    /**
     * @return the document
     */
    public byte[] getDocument() {
        return this.document_;
    }
    /**
     * @param document the document to set
     */
    public void setDocument(byte[] document) {
        this.document_ = document;
    }
    /**
     * @return the documentDate
     */
    public Date getDocumentDate() {
        return this.documentDate_;
    }
    /**
     * @param documentDate the documentDate to set
     */
    public void setDocumentDate(Date documentDate) {
        this.documentDate_ = documentDate;
    }
    /**
     * @return the documentId
     */
    public String getDocumentId() {
        return this.documentId_;
    }
    /**
     * @param documentId the documentId to set
     */
    public void setDocumentId(String documentId) {
        this.documentId_ = documentId;
    }
    /**
     * @return the documentReferenceFileResource
     */
    public String getDocumentReferenceFileResource() {
        return this.documentReferenceFileResource_;
    }
    /**
     * @param documentReferenceFileResource the documentReferenceFileResource to set
     */
    public void setDocumentReferenceFileResource(
            String documentReferenceFileResource) {
        this.documentReferenceFileResource_ = documentReferenceFileResource;
    }
    
    

}
