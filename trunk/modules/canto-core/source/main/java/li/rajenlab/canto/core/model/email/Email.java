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

import java.util.Date;
import java.util.List;

import li.rajenlab.canto.core.model.Entity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.cases.Case;
import li.rajenlab.canto.core.model.common.Contact;
import li.rajenlab.canto.core.model.oppportunity.Opportunity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Email extends Entity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5883021888930798446L;
    private String contentAsText_;
    private String contenctAsHtml_;
    private EmailStatus status_;
    private Date sendDate_;
    private Date sentDate_;
    private String fromAadress_;
    private String fromName_;
    private List<String> toAddress_;
    private List<String> ccAddress_;
    private List<String> bccAddress_;
    private String messageId_;
    private String rawSource_;
    private String replyToAddress_;
   
    
    private List<Attachment> attachments_;
    
    private Account account_;
    private Opportunity opportunty_;
    private Case case_;
    private Contact contact_;
    
    /**
     * @return the account
     */
    public Account getAccount() {
        return this.account_;
    }
    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account_ = account;
    }
    /**
     * @return the case
     */
    public Case getCase() {
        return this.case_;
    }
    /**
     * @param case1 the case to set
     */
    public void setCase(Case case1) {
        this.case_ = case1;
    }
    /**
     * @return the contact
     */
    public Contact getContact() {
        return this.contact_;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact_ = contact;
    }
    /**
     * @return the contenctAsHtml
     */
    public String getContenctAsHtml() {
        return this.contenctAsHtml_;
    }
    /**
     * @param contenctAsHtml the contenctAsHtml to set
     */
    public void setContenctAsHtml(String contenctAsHtml) {
        this.contenctAsHtml_ = contenctAsHtml;
    }
    /**
     * @return the contentAsText
     */
    public String getContentAsText() {
        return this.contentAsText_;
    }
    /**
     * @param contentAsText the contentAsText to set
     */
    public void setContentAsText(String contentAsText) {
        this.contentAsText_ = contentAsText;
    }
    /**
     * @return the opportunty
     */
    public Opportunity getOpportunty() {
        return this.opportunty_;
    }
    /**
     * @param opportunty the opportunty to set
     */
    public void setOpportunty(Opportunity opportunty) {
        this.opportunty_ = opportunty;
    }
    /**
     * @return the sendDate
     */
    public Date getSendDate() {
        return this.sendDate_;
    }
    /**
     * @param sendDate the sendDate to set
     */
    public void setSendDate(Date sendDate) {
        this.sendDate_ = sendDate;
    }
    /**
     * @return the sentDate
     */
    public Date getSentDate() {
        return this.sentDate_;
    }
    /**
     * @param sentDate the sentDate to set
     */
    public void setSentDate(Date sentDate) {
        this.sentDate_ = sentDate;
    }
    /**
     * @return the status
     */
    public EmailStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(EmailStatus status) {
        this.status_ = status;
    }
    /**
     * @return the attachments
     */
    public List<Attachment> getAttachments() {
        return this.attachments_;
    }
    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments_ = attachments;
    }
    /**
     * @return the bccAddress
     */
    public List<String> getBccAddress() {
        return this.bccAddress_;
    }
    /**
     * @param bccAddress the bccAddress to set
     */
    public void setBccAddress(List<String> bccAddress) {
        this.bccAddress_ = bccAddress;
    }
    /**
     * @return the ccAddress
     */
    public List<String> getCcAddress() {
        return this.ccAddress_;
    }
    /**
     * @param ccAddress the ccAddress to set
     */
    public void setCcAddress(List<String> ccAddress) {
        this.ccAddress_ = ccAddress;
    }
    /**
     * @return the fromAadress
     */
    public String getFromAadress() {
        return this.fromAadress_;
    }
    /**
     * @param fromAadress the fromAadress to set
     */
    public void setFromAadress(String fromAadress) {
        this.fromAadress_ = fromAadress;
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
     * @return the messageId
     */
    public String getMessageId() {
        return this.messageId_;
    }
    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId_ = messageId;
    }
    /**
     * @return the rawSource
     */
    public String getRawSource() {
        return this.rawSource_;
    }
    /**
     * @param rawSource the rawSource to set
     */
    public void setRawSource(String rawSource) {
        this.rawSource_ = rawSource;
    }
    /**
     * @return the replyToAddress
     */
    public String getReplyToAddress() {
        return this.replyToAddress_;
    }
    /**
     * @param replyToAddress the replyToAddress to set
     */
    public void setReplyToAddress(String replyToAddress) {
        this.replyToAddress_ = replyToAddress;
    }
    /**
     * @return the toAddress
     */
    public List<String> getToAddress() {
        return this.toAddress_;
    }
    /**
     * @param toAddress the toAddress to set
     */
    public void setToAddress(List<String> toAddress) {
        this.toAddress_ = toAddress;
    }
    
    

}
