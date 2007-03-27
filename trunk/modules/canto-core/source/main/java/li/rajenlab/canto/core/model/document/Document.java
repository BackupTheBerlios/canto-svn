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

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Document extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -3678522003373910766L;
    private Date publishDate_;
    private Date expiryDate_;
    private Revision relatedDocumentRevision_;
    private String fileName_;
    private Document relatedDocument_;
    private boolean isTemplate_;
    private String contentType_;
    private DocumentStatus status_;
    private DocumentCategory category_;
    private String description_;
    private DocumentType documentType_;
    
    /**
     * @return the category
     */
    public DocumentCategory getCategory() {
        return this.category_;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(DocumentCategory category) {
        this.category_ = category;
    }
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
     * @return the documentType
     */
    public DocumentType getDocumentType() {
        return this.documentType_;
    }
    /**
     * @param documentType the documentType to set
     */
    public void setDocumentType(DocumentType documentType) {
        this.documentType_ = documentType;
    }
    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return this.expiryDate_;
    }
    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate_ = expiryDate;
    }
    /**
     * @return the fileName
     */
    public String getFileName() {
        return this.fileName_;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName_ = fileName;
    }
    /**
     * @return the isTemplate
     */
    public boolean isTemplate() {
        return this.isTemplate_;
    }
    /**
     * @param isTemplate the isTemplate to set
     */
    public void setTemplate(boolean isTemplate) {
        this.isTemplate_ = isTemplate;
    }
    /**
     * @return the publishDate
     */
    public Date getPublishDate() {
        return this.publishDate_;
    }
    /**
     * @param publishDate the publishDate to set
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate_ = publishDate;
    }
    /**
     * @return the relatedDocument
     */
    public Document getRelatedDocument() {
        return this.relatedDocument_;
    }
    /**
     * @param relatedDocument the relatedDocument to set
     */
    public void setRelatedDocument(Document relatedDocument) {
        this.relatedDocument_ = relatedDocument;
    }
    /**
     * @return the relatedDocumentRevision
     */
    public Revision getRelatedDocumentRevision() {
        return this.relatedDocumentRevision_;
    }
    /**
     * @param relatedDocumentRevision the relatedDocumentRevision to set
     */
    public void setRelatedDocumentRevision(Revision relatedDocumentRevision) {
        this.relatedDocumentRevision_ = relatedDocumentRevision;
    }
    /**
     * @return the status
     */
    public DocumentStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(DocumentStatus status) {
        this.status_ = status;
    }
    
    
    
}
