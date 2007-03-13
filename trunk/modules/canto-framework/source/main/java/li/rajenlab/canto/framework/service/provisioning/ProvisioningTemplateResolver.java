/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.provisioning;

import li.rajenlab.canto.framework.domain.order.OrderType;
import li.rajenlab.canto.framework.domain.provisioning.ProvisioningTemplate;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProvisioningTemplateResolver {
    
    
    public ProvisioningTemplate resolveProvisiongTemplate(OrderType orderType);

}
