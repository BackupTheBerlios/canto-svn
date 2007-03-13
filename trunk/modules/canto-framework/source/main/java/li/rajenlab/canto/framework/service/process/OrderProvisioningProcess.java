/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.process;



/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface OrderProvisioningProcess {
    
    /**
     * Schedule the process of the step of order provisioning
     * @param orderProvisioningId
     * @return OrderProvisioningProcessState
     */
    public OrderProvisioningProcessState scheduleOrderProvisioningStep(String orderProvisioningId);

}
