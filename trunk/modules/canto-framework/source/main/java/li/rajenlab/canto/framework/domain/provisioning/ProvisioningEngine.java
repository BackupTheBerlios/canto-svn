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


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProvisioningEngine {
    
    
    /**
     * Do the provisioning
     * @param context
     */
    public void doProvisioning(ProvisioningContext context);

}
