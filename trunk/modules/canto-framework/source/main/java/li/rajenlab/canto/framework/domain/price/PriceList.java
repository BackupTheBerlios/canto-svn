/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.price;

import java.util.Date;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class PriceList extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2785012726065753362L;
    private String priceListId_;
    private String name_;
    private boolean isDefault_;
    private Date introductionDate_;
    private Date expirationDate_;
    
    /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return this.expirationDate_;
    }
    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate_ = expirationDate;
    }
    /**
     * @return the introductionDate
     */
    public Date getIntroductionDate() {
        return this.introductionDate_;
    }
    /**
     * @param introductionDate the introductionDate to set
     */
    public void setIntroductionDate(Date introductionDate) {
        this.introductionDate_ = introductionDate;
    }
    /**
     * @return the isDefault
     */
    public boolean isDefault() {
        return this.isDefault_;
    }
    /**
     * @param isDefault the isDefault to set
     */
    public void setDefault(boolean isDefault) {
        this.isDefault_ = isDefault;
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
     * @return the priceListId
     */
    public String getPriceListId() {
        return this.priceListId_;
    }
    /**
     * @param priceListId the priceListId to set
     */
    public void setPriceListId(String priceListId) {
        this.priceListId_ = priceListId;
    }
    
    

}
