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
public class ProvisioningActionContext implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5435903203528454817L;
    
    private Object data_;

    /**
     * @return the data
     */
    public Object getData() {
        return this.data_;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data_ = data;
    }
    
    

}
