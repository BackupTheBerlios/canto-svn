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

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity(name="Account")
@Table(name="ACCOUNT")

public class Account extends BeanEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1412380490817658383L;
   
    // Entity Field
    @Id
    private String accountId;
    private String accountName;
    private String webSite;
    private String tickerSymbol;
    private Organization memberOf;
    private AccountType type;
    private AccountStatus status;
    private Account parentOf;
    private Address billingAddress;
    private Address shippingAddress;
    private String phone;
    private String fax;
    private String email;
    private String emailSecondary;
    private int employees;
    private String rating;
    private String name;
    private Address legalAddress;

    
    /**
     * @return the accountName
     */
    public String getAccountName() {
        return this.accountName;
    }
    /**
     * @param accountName the accountName to set
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    /**
     * @return the billingAddress
     */
    public Address getBillingAddress() {
        return this.billingAddress;
    }
    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the emailSecondary
     */
    public String getEmailSecondary() {
        return this.emailSecondary;
    }
    /**
     * @param emailSecondary the emailSecondary to set
     */
    public void setEmailSecondary(String emailSecondary) {
        this.emailSecondary = emailSecondary;
    }
    /**
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }
    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * @return the memberOf
     */
    public Organization getMemberOf() {
        return this.memberOf;
    }
    /**
     * @param memberOf the memberOf to set
     */
    public void setMemberOf(Organization memberOf) {
        this.memberOf = memberOf;
    }
   
    /**
     * @return the parentOf
     */
    public Account getParentOf() {
        return this.parentOf;
    }
    /**
     * @param parentOf the parentOf to set
     */
    public void setParentOf(Account parentOf) {
        this.parentOf = parentOf;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the shippingAddress
     */
    public Address getShippingAddress() {
        return this.shippingAddress;
    }
    /**
     * @param shippingAddress the shippingAddress to set
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    /**
     * @return the status
     */
    public AccountStatus getStatus() {
        return this.status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    /**
     * @return the tickerSymbol
     */
    public String getTickerSymbol() {
        return this.tickerSymbol;
    }
    /**
     * @param tickerSymbol the tickerSymbol to set
     */
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }
    /**
     * @return the type
     */
    public AccountType getType() {
        return this.type;
    }
    /**
     * @param type the type to set
     */
    public void setType(AccountType type) {
        this.type = type;
    }
    /**
     * @return the webSite
     */
    public String getWebSite() {
        return this.webSite;
    }
    /**
     * @param webSite the webSite to set
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    /**
     * @return the employees
     */
    public int getEmployees() {
        return this.employees;
    }
    /**
     * @param employees the employees to set
     */
    public void setEmployees(int employees) {
        this.employees = employees;
    }
    /**
     * @return the legalAddress
     */
    public Address getLegalAddress() {
        return this.legalAddress;
    }
    /**
     * @param legalAddress the legalAddress to set
     */
    public void setLegalAddress(Address legalAddress) {
        this.legalAddress = legalAddress;
    }
    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the rating
     */
    public String getRating() {
        return this.rating;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
    /**
     * @return the accountId
     */
    public String getAccountId() {
        return this.accountId;
    }
    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    

}
