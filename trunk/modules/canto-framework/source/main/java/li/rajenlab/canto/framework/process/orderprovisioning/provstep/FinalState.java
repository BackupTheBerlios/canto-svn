/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.process.orderprovisioning.provstep;

import li.rajenlab.canto.framework.service.process.OrderProvisioningProcessState;
import li.rajenlab.common.service.process.state.BaseState;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class FinalState extends BaseState {

    /**
     * @see li.rajenlab.common.service.process.state.State#getName()
     */
    public String getName() {
        return OrderProvisioningProcessState.FINAL.getValue();
    }

}
