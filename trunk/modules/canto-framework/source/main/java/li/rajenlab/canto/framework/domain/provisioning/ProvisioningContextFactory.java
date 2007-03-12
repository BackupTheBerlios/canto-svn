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
public interface ProvisioningContextFactory<E> {
    
    /**
     * Create a provisioning context
     * @return
     */
    public E createContext();

}
