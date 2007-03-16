/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.price;

import java.util.Date;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractPriceList extends AbstractEntity {
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -1608829205090477406L;
    private String priceListId_;
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
