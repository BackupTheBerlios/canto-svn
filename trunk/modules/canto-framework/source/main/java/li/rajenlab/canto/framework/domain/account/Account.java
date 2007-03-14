/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.account;

import li.rajenlab.canto.framework.domain.common.Contact;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Account extends AbstractEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5079722621931306532L;
    
    private String accountId_;
    private Contact legalContact_;
    private Contact billingContact_;
    private Contact mailingContact_;
    private AccountStatus status_ = AccountStatus.NEW;
    private AccountType type_ ;
    
    /**
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId_;
    }
    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId_ = accountId;
    }
    /**
     * @return the billingContact
     */
    public Contact getBillingContact() {
        return this.billingContact_;
    }
    /**
     * @param billingContact the billingContact to set
     */
    public void setBillingContact(Contact billingContact) {
        this.billingContact_ = billingContact;
    }
   
    /**
     * @return the legalContact
     */
    public Contact getLegalContact() {
        return this.legalContact_;
    }
    /**
     * @param legalContact the legalContact to set
     */
    public void setLegalContact(Contact legalContact) {
        this.legalContact_ = legalContact;
    }
    /**
     * @return the status
     */
    public AccountStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(AccountStatus status) {
        this.status_ = status;
    }
   
    /**
     * @return the type
     */
    public AccountType getType() {
        return this.type_;
    }
    /**
     * @param type the type to set
     */
    public void setType(AccountType type) {
        this.type_ = type;
    }
    /**
     * @return the mailingContact
     */
    public Contact getMailingContact() {
        return this.mailingContact_;
    }
    /**
     * @param mailingContact the mailingContact to set
     */
    public void setMailingContact(Contact mailingContact) {
        this.mailingContact_ = mailingContact;
    }
    
    

}
