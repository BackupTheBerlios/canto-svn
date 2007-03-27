/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.model.product;

import java.util.Date;

import li.rajenlab.canto.core.model.BeanEntity;
import li.rajenlab.canto.core.model.account.Account;
import li.rajenlab.canto.core.model.contact.Contact;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Product extends BeanEntity {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -663008809539674753L;
    
    private ProductCatalogItem product_;
    private ProductStatus status_;
    private Account account_;
    private Contact contact_;
    private int quantity_;
    private Date purchased_;
    private Date supportStart_;
    private Date supportExpires_;
    private String currentcy_;
    private float bookValue_; //f the account is purchasing the product, enter the amount of the order that was booked.
    private Date bookDate_;
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
     * @return the bookDate
     */
    public Date getBookDate() {
        return this.bookDate_;
    }
    /**
     * @param bookDate the bookDate to set
     */
    public void setBookDate(Date bookDate) {
        this.bookDate_ = bookDate;
    }
    /**
     * @return the bookValue
     */
    public float getBookValue() {
        return this.bookValue_;
    }
    /**
     * @param bookValue the bookValue to set
     */
    public void setBookValue(float bookValue) {
        this.bookValue_ = bookValue;
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
     * @return the currentcy
     */
    public String getCurrentcy() {
        return this.currentcy_;
    }
    /**
     * @param currentcy the currentcy to set
     */
    public void setCurrentcy(String currentcy) {
        this.currentcy_ = currentcy;
    }
    /**
     * @return the product
     */
    public ProductCatalogItem getProduct() {
        return this.product_;
    }
    /**
     * @param product the product to set
     */
    public void setProduct(ProductCatalogItem product) {
        this.product_ = product;
    }
    /**
     * @return the purchased
     */
    public Date getPurchased() {
        return this.purchased_;
    }
    /**
     * @param purchased the purchased to set
     */
    public void setPurchased(Date purchased) {
        this.purchased_ = purchased;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return this.quantity_;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity_ = quantity;
    }
    /**
     * @return the status
     */
    public ProductStatus getStatus() {
        return this.status_;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(ProductStatus status) {
        this.status_ = status;
    }
    /**
     * @return the supportExpires
     */
    public Date getSupportExpires() {
        return this.supportExpires_;
    }
    /**
     * @param supportExpires the supportExpires to set
     */
    public void setSupportExpires(Date supportExpires) {
        this.supportExpires_ = supportExpires;
    }
    /**
     * @return the supportStart
     */
    public Date getSupportStart() {
        return this.supportStart_;
    }
    /**
     * @param supportStart the supportStart to set
     */
    public void setSupportStart(Date supportStart) {
        this.supportStart_ = supportStart;
    }
    
  

}
