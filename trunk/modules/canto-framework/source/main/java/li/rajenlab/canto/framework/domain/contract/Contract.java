/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.contract;

import java.util.Date;
import java.util.SortedSet;

import li.rajenlab.canto.framework.domain.account.Account;
import li.rajenlab.canto.framework.domain.order.Order;
import li.rajenlab.canto.framework.domain.product.Product;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class Contract extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3029503423098377321L;
    
    private Account account_;
    private Product product_;
    private Date  startDate_;
    private Date  endDate_;
    private int   rollover_;
    private Date installationDate_;
    private float etf_;
    private SortedSet<Order> orders_;
    
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
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate_;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate_ = endDate;
    }
    /**
     * @return the etf
     */
    public float getEtf() {
        return this.etf_;
    }
    /**
     * @param etf the etf to set
     */
    public void setEtf(float etf) {
        this.etf_ = etf;
    }
    /**
     * @return the installationDate
     */
    public Date getInstallationDate() {
        return this.installationDate_;
    }
    /**
     * @param installationDate the installationDate to set
     */
    public void setInstallationDate(Date installationDate) {
        this.installationDate_ = installationDate;
    }
    /**
     * @return the orders
     */
    public SortedSet<Order> getOrders() {
        return this.orders_;
    }
    /**
     * @param orders the orders to set
     */
    public void setOrders(SortedSet<Order> orders) {
        this.orders_ = orders;
    }
    /**
     * @return the product
     */
    public Product getProduct() {
        return this.product_;
    }
    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product_ = product;
    }
    /**
     * @return the rollover
     */
    public int getRollover() {
        return this.rollover_;
    }
    /**
     * @param rollover the rollover to set
     */
    public void setRollover(int rollover) {
        this.rollover_ = rollover;
    }
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate_;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate_ = startDate;
    }
    
    
    

}
