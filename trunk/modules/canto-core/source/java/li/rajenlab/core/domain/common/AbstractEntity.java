/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.core.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public abstract class AbstractEntity implements Serializable {
    
    
    private Serializable id_;
    private Date createTime_;
    private Date modifiedDate_;
    
    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return this.createTime_;
    }
    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime_ = createTime;
    }
    /**
     * @return the id
     */
    public Serializable getId() {
        return this.id_;
    }
    /**
     * @param id the id to set
     */
    private void setId(Serializable id) {
        this.id_ = id;
    }
    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return this.modifiedDate_;
    }
    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate_ = modifiedDate;
    }
    
    
    
    
    
    

}
