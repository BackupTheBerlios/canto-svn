/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.provisioning;

import java.util.Date;

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ProvisioningStep extends AbstractEntity {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1636762345216101321L;
    
    private String provisioningActionName_;
    private boolean executed_;
    private Date executionDate_;
    private String executionDoneBy_;
    
    /**
     * @return the provisioningActionName
     */
    public String getProvisioningActionName() {
        return this.provisioningActionName_;
    }
    /**
     * @param provisioningActionName the provisioningActionName to set
     */
    public void setProvisioningActionName(String provisioningActionName) {
        this.provisioningActionName_ = provisioningActionName;
    }
    /**
     * @return the executed
     */
    public boolean isExecuted() {
        return this.executed_;
    }
    /**
     * @param executed the executed to set
     */
    public void setExecuted(boolean executed) {
        this.executed_ = executed;
    }
    /**
     * @return the executionDate
     */
    public Date getExecutionDate() {
        return this.executionDate_;
    }
    /**
     * @param executionDate the executionDate to set
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate_ = executionDate;
    }
    /**
     * @return the executionDoneBy
     */
    public String getExecutionDoneBy() {
        return this.executionDoneBy_;
    }
    /**
     * @param executionDoneBy the executionDoneBy to set
     */
    public void setExecutionDoneBy(String executionDoneBy) {
        this.executionDoneBy_ = executionDoneBy;
    }
    
    
    

}
