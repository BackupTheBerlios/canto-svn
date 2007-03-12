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
public interface ProvisioningEngine<E> {
    
    
    /**
     * Do the provisioning
     * @param context
     */
    public void doProvisioning(E context);

}
