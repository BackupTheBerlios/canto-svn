/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.domain.order;

import java.io.Serializable;

import org.springframework.core.style.ToStringCreator;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderType implements Serializable {
    
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 4958534098975457595L;
    
    private String requestType_;
    private String serviceType_;
    private int version_;
    
    /**
     * @return the requestType
     */
    public String getRequestType() {
        return this.requestType_;
    }
    /**
     * @param requestType the requestType to set
     */
    public void setRequestType(String requestType) {
        this.requestType_ = requestType;
    }
    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return this.serviceType_;
    }
    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType_ = serviceType;
    }
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("requestType", getRequestType())
            .append("serviceType", getServiceType())
            .append("version", getVersion())
            .toString();
    }
    /**
     * @return the version
     */
    public int getVersion() {
        return this.version_;
    }
    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version_ = version;
    }
    
 

    
}
