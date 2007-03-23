/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.action;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.document.Document;
import li.rajenlab.common.domain.security.User;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Action implements Serializable {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1670167716091475608L;
    private String id_;
    private String titel_;
    private String description_;
    private Date actionDate_;
    private User actionBy_;
    private List<Document> attachments_;
    private ActionStatus actionStatus_;
    private ActionType actionType_;
    
    /**
     * @return the actionBy
     */
    public User getActionBy() {
        return this.actionBy_;
    }
    /**
     * @param actionBy the actionBy to set
     */
    public void setActionBy(User actionBy) {
        this.actionBy_ = actionBy;
    }
    /**
     * @return the actionDate
     */
    public Date getActionDate() {
        return this.actionDate_;
    }
    /**
     * @param actionDate the actionDate to set
     */
    public void setActionDate(Date actionDate) {
        this.actionDate_ = actionDate;
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
     * @return the titel
     */
    public String getTitel() {
        return this.titel_;
    }
    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
        this.titel_ = titel;
    }
    /**
     * @return the actionStatus
     */
    public ActionStatus getActionStatus() {
        return this.actionStatus_;
    }
    /**
     * @param actionStatus the actionStatus to set
     */
    public void setActionStatus(ActionStatus actionStatus) {
        this.actionStatus_ = actionStatus;
    }
    /**
     * @return the actionType
     */
    public ActionType getActionType() {
        return this.actionType_;
    }
    /**
     * @param actionType the actionType to set
     */
    public void setActionType(ActionType actionType) {
        this.actionType_ = actionType;
    }
    /**
     * @return the attachments
     */
    public List<Document> getAttachments() {
        return this.attachments_;
    }
    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(List<Document> attachments) {
        this.attachments_ = attachments;
    }
    
    

}
