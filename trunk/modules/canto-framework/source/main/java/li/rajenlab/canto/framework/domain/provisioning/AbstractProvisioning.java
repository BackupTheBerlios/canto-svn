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
import java.util.List;
import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractProvisioning extends AbstractEntity{
    
    
    private ProvisioningStatus status_;
    private String provisioningId_;
    private Date nextStepDate_;
    private Date startDate_;
    private List<ProvisioningStep> steps_;
    private int nextStepIndex_ = 0;
    
    /**
     * @return the status
     */
    public ProvisioningStatus getStatus() {
        return this.status_;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ProvisioningStatus status) {
        this.status_ = status;
    }

   
    /**
     * @return the provisioningId
     */
    public String getProvisioningId() {
        return this.provisioningId_;
    }

    /**
     * @param provisioningId the provisioningId to set
     */
    public void setProvisioningId(String provisioningId) {
        this.provisioningId_ = provisioningId;
    }

    /**
     * @return the nextStepDate
     */
    public Date getNextStepDate() {
        return this.nextStepDate_;
    }

    /**
     * @param nextStepDate the nextStepDate to set
     */
    public void setNextStepDate(Date nextStepDate) {
        this.nextStepDate_ = nextStepDate;
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

    /**
     * @return the steps
     */
    public List<ProvisioningStep> getSteps() {
        return this.steps_;
    }

    /**
     * @param steps the steps to set
     */
    public void setSteps(List<ProvisioningStep> steps) {
        this.steps_ = steps;
    }

    /**
     * @return the nextStepIndex
     */
    public int getNextStepIndex() {
        return this.nextStepIndex_;
    }

    /**
     * @param nextStepIndex the nextStepIndex to set
     */
    public void setNextStepIndex(int nextStepIndex) {
        this.nextStepIndex_ = nextStepIndex;
    }
    
    
    
}
