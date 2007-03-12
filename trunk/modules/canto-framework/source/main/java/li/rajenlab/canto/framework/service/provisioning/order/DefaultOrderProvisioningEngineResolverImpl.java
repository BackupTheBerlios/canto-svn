/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.service.provisioning.order;

import java.util.Map;

import li.rajenlab.canto.framework.domain.order.OrderType;
import li.rajenlab.canto.framework.domain.provisioning.order.OrderProvisioningEngine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DefaultOrderProvisioningEngineResolverImpl implements
        OrderProvisioningEngineResolver {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(DefaultOrderProvisioningEngineResolverImpl.class);

    private Map<String,OrderProvisioningEngine> engineBeanRefs_;
    private String delimiter_ = "_";
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    /**
     * @see li.rajenlab.canto.framework.service.provisioning.order.OrderProvisioningEngineResolver#resolveProvisioningEngineForOrder(li.rajenlab.canto.framework.domain.order.OrderType)
     */
    public OrderProvisioningEngine resolveProvisioningEngineForOrder(
            OrderType orderType) {
        String engineBeanRefKey  = orderType.getRequestType() + getDelimiter() +orderType.getServiceType();
        
        OrderProvisioningEngine engine = getEngineBeanRefs().get(engineBeanRefKey);
        if (engine == null){
            throw new IllegalArgumentException("No ProvisionEngine found for key ["+engineBeanRefKey+"]");
        }
        return engine;
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

   

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------
    /**
     * @return the engineBeanRefs
     */
    public Map<String, OrderProvisioningEngine> getEngineBeanRefs() {
        return this.engineBeanRefs_;
    }

    /**
     * @param engineBeanRefs the engineBeanRefs to set
     */
    public void setEngineBeanRefs(Map<String, OrderProvisioningEngine> engineBeanRefs) {
        this.engineBeanRefs_ = engineBeanRefs;
    }



    /**
     * @return the delimiter
     */
    public String getDelimiter() {
        return this.delimiter_;
    }



    /**
     * @param delimiter the delimiter to set
     */
    public void setDelimiter(String delimiter) {
        this.delimiter_ = delimiter;
    }
  

}
