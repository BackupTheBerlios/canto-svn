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

import java.util.List;

import li.rajenlab.canto.core.model.BeanEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class EmailTemplate extends BeanEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5650116931027473581L;
    private boolean published;
    private String body_;
    private String body_html;
    private List<Attachment> attachments;
    private String fromName_;
    private String fromAddress_;
    
    /**
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
        return this.attachments;
    }
    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
    /**
     * @return the body
     */
    public String getBody() {
        return this.body_;
    }
    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body_ = body;
    }
    /**
     * @return the body_html
     */
    public String getBody_html() {
        return this.body_html;
    }
    /**
     * @param body_html the body_html to set
     */
    public void setBody_html(String body_html) {
        this.body_html = body_html;
    }
    /**
     * @return the fromAddress
     */
    public String getFromAddress() {
        return this.fromAddress_;
    }
    /**
     * @param fromAddress the fromAddress to set
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress_ = fromAddress;
    }
    /**
     * @return the fromName
     */
    public String getFromName() {
        return this.fromName_;
    }
    /**
     * @param fromName the fromName to set
     */
    public void setFromName(String fromName) {
        this.fromName_ = fromName;
    }
    /**
     * @return the published
     */
    public boolean isPublished() {
        return this.published;
    }
    /**
     * @param published the published to set
     */
    public void setPublished(boolean published) {
        this.published = published;
    }
    
    


}
