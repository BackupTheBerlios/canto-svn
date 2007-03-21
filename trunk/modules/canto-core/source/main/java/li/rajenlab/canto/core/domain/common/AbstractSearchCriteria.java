/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.core.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractSearchCriteria implements Serializable {
    
    
    private String name_;
    private String ouid_;
    private Date fromDate_;
    private Date toDate_;
    
    
    /**
     * @return the fromDate
     */
    public Date getFromDate() {
        return this.fromDate_;
    }
    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(Date fromDate) {
        this.fromDate_ = fromDate;
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
     * @return the ouid
     */
    public String getOuid() {
        return this.ouid_;
    }
    /**
     * @param ouid the ouid to set
     */
    public void setOuid(String ouid) {
        this.ouid_ = ouid;
    }
    /**
     * @return the toDate
     */
    public Date getToDate() {
        return this.toDate_;
    }
    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Date toDate) {
        this.toDate_ = toDate;
    }
    
    

}
