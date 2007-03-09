/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.account;

import java.io.Serializable;

import li.rajenlab.canto.framework.domain.common.Contact;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SearchAccountCriteria implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 5453915009589768479L;
    
    
    private Contact legalContact_;
    private AccountStatus status_;
    private AccountType type_;
    
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
    
    
    

}
