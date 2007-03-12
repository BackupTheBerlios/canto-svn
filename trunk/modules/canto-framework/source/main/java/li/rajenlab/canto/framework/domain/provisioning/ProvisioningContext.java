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

import java.io.Serializable;


/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface ProvisioningContext extends Serializable {
    
    
   /** 
     * @return the request
     */
    public ProvisioningRequest getRequest();
     
   
    /**
     * @return the response
     */
    public ProvisioningResponse getResponse();
    

}
