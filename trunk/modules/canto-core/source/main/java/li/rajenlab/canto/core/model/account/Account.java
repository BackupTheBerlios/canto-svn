/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.account;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.common.Address;
import li.rajenlab.canto.core.model.organization.Organization;

/**
 * An account contains your customer information such as name and address. 
 * Each account can be associated with other records 
 * such as opportunities and contacts
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Account extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1412380490817658383L;
   
    // Entity Field
    private String accountName_;
    private String webSite_;
    private String tickerSymbol_;
    private Organization memberOf_;
    private AccountType type_;
    private AccountStatus status_;
    private Account parentOf_;
    private Address billingAddress_;
    private Address shippingAddress_;
    private String phone_;
    private String fax_;
    private String email_;
    private String emailSecondary_;
    private int employees_;
    private String rating_;
    private String name_;
    private Address legalAddress_;

    
    /**
     * @return the accountName
     */
    public String getAccountName() {
        return this.accountName_;
    }
    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName_ = accountName;
    }
    /**
     * @return the billingAddress
     */
    public Address getBillingAddress() {
        return this.billingAddress_;
    }
    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress_ = billingAddress;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return this.email_;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email_ = email;
    }
    /**
     * @return the emailSecondary
     */
    public String getEmailSecondary() {
        return this.emailSecondary_;
    }
    /**
     * @param emailSecondary the emailSecondary to set
     */
    public void setEmailSecondary(String emailSecondary) {
        this.emailSecondary_ = emailSecondary;
    }
    /**
     * @return the fax
     */
    public String getFax() {
        return this.fax_;
    }
    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax_ = fax;
    }
    /**
     * @return the memberOf
     */
    public Organization getMemberOf() {
        return this.memberOf_;
    }
    /**
     * @param memberOf the memberOf to set
     */
    public void setMemberOf(Organization memberOf) {
        this.memberOf_ = memberOf;
    }
   
    /**
     * @return the parentOf
     */
    public Account getParentOf() {
        return this.parentOf_;
    }
    /**
     * @param parentOf the parentOf to set
     */
    public void setParentOf(Account parentOf) {
        this.parentOf_ = parentOf;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return this.phone_;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone_ = phone;
    }
    /**
     * @return the shippingAddress
     */
    public Address getShippingAddress() {
        return this.shippingAddress_;
    }
    /**
     * @param shippingAddress the shippingAddress to set
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress_ = shippingAddress;
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
     * @return the tickerSymbol
     */
    public String getTickerSymbol() {
        return this.tickerSymbol_;
    }
    /**
     * @param tickerSymbol the tickerSymbol to set
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol_ = tickerSymbol;
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
     * @return the webSite
     */
    public String getWebSite() {
        return this.webSite_;
    }
    /**
     * @param webSite the webSite to set
     */
    public void setWebSite(String webSite) {
        this.webSite_ = webSite;
    }
    /**
     * @return the employees
     */
    public int getEmployees() {
        return this.employees_;
    }
    /**
     * @param employees the employees to set
     */
    public void setEmployees(int employees) {
        this.employees_ = employees;
    }
    /**
     * @return the legalAddress
     */
    public Address getLegalAddress() {
        return this.legalAddress_;
    }
    /**
     * @param legalAddress the legalAddress to set
     */
    public void setLegalAddress(Address legalAddress) {
        this.legalAddress_ = legalAddress;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name_;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name_ = name;
    }
    /**
     * @return the rating
     */
    public String getRating() {
        return this.rating_;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating_ = rating;
    }
    
    
   
    
    
    

}
