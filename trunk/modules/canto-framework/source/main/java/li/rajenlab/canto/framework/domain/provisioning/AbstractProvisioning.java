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

import li.rajenlab.common.domain.AbstractEntity;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class AbstractProvisioning extends AbstractEntity {
    
    
    private ProvisioningStatus status_;
    private ProvisioningTemplate template_;

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
     * @return the template
     */
    public ProvisioningTemplate getTemplate() {
        return this.template_;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(ProvisioningTemplate template) {
        this.template_ = template;
    }
    
    
    
}
