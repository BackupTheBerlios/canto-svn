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
 * Definition of a provision action of provision step. The action is invoked
 * by using the action name defined {@link ProvisioningStep#getProvisioningActionName()}
 * by reflection
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProvisioningAction {
    
    
    /**
     * Peform the action
     *
     */
    public void doAction(ProvisioningActionContext context);

}
