/****************************************************************************** 
 * $LastChangedBy:neoraph $
 * $LastChangedRevision:48 $
 * $LastChangedDate:2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) $
 * 
 * 
 ******************************************************************************
 * Project: canto-core
 ******************************************************************************
 * $HeadURL:svn+ssh://svn.berlios.de/svnroot/repos/canto/trunk/modules/rajenlab-common/source/main/java/li/rajenlab/common/domain/AbstractEntity.java $
 ******************************************************************************/

package li.rajenlab.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id:AbstractEntity.java 48 2007-03-07 13:51:41 +0000 (Mi, 07 Mrz 2007) neoraph $
 */
public abstract class AbstractEntity implements Serializable {
    
    
    private Serializable id_;
    private Date createTime_;
    private Date changeTime_;
    
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
     * @return the changeTime
     */
    public Date getChangeTime() {
        return this.changeTime_;
    }
    /**
     * @param changeTime the changeTime to set
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime_ = changeTime;
    }

    
    
    
    
    
    
    

}
