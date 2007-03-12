/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.process.order.provisioning;

import li.rajenlab.canto.framework.domain.common.CantoProcessState;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class InitialState extends BaseProvisioningState {

    /**
     * @see li.rajenlab.common.service.process.state.State#getName()
     */
    public String getName() {
        return CantoProcessState.INITIAL.getValue();
    }
   
}
