/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: canto-framework
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.canto.framework.process.orderprovisioning.waitnextstep;

import li.rajenlab.canto.framework.service.provisioning.ProvisioningService;
import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.service.process.StatefullProcessImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class OrderProvisioningWaitNextStepProcess extends StatefullProcessImpl {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory
            .getLog(OrderProvisioningWaitNextStepProcess.class);

    private String singletonProcessOid_;
    private int pollingStepInMinutes_  = 1;
    private ProvisioningService provisioningService_;
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    @Override
    public void onBoot() {
        log.debug("entering: onBoot()");
        ProcessInstance instance = getProcessInstanceDAO().findByOid(getName(),getSingletonProcessOid());
        if(instance == null) {
            log.debug("creating new process instance");
            instance = new ProcessInstance();
            instance.setOid(getSingletonProcessOid());
            instance.setProcessName(getName());
            
            StateWaitNextProvStepScheduler state = new StateWaitNextProvStepScheduler();
            state.setProcessInstance(instance);
            state.setProcess(this);
            state.setProvisioningService(getProvisioningService());
            instance.setStateName(state.getName());
            
            state.onEntry();
            
            getProcessInstanceDAO().save(instance);
        }
    }
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    /**
     * @return the singletonProcessOid
     */
    public String getSingletonProcessOid() {
        return this.singletonProcessOid_;
    }

    /**
     * @param singletonProcessOid the singletonProcessOid to set
     */
    public void setSingletonProcessOid(String singletonProcessOid) {
        this.singletonProcessOid_ = singletonProcessOid;
    }

    /**
     * @return the pollingStepInMinutes
     */
    public int getPollingStepInMinutes() {
        return this.pollingStepInMinutes_;
    }

    /**
     * @param pollingStepInMinutes the pollingStepInMinutes to set
     */
    public void setPollingStepInMinutes(int pollingStepInMinutes) {
        this.pollingStepInMinutes_ = pollingStepInMinutes;
    }

    /**
     * @return the provisioningService
     */
    public ProvisioningService getProvisioningService() {
        return this.provisioningService_;
    }

    /**
     * @param provisioningService the provisioningService to set
     */
    public void setProvisioningService(ProvisioningService provisioningService) {
        this.provisioningService_ = provisioningService;
    }

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

}
