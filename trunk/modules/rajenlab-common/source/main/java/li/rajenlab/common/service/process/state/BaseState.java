/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process.state;

import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.service.process.Process;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class BaseState implements State {

    

    protected  Log log = LogFactory.getLog(getClass());
    
    protected Process process_;
    protected Event event_;
    protected ProcessInstance processInstance_;
    
 
    /**
     * @see li.rajenlab.common.service.process.state.State#onEntry()
     */
    public void onEntry() {
        logTransitionMethod("onEntry");
    }

    /**
     * @see li.rajenlab.common.service.process.state.State#onExit()
     */
    public void onExit() {
        logTransitionMethod("onExit");
    }

    /**
     * @see li.rajenlab.common.service.process.state.State#setEvent(li.rajenlab.common.domain.event.Event)
     */
    public void setEvent(Event event) {
        this.event_ = event;
    }

    /**
     * @see li.rajenlab.common.service.process.state.State#setProcess(li.rajenlab.common.service.process.Process)
     */
    public void setProcess(Process process) {
        this.process_ = process;
    }

    /**
     * @see li.rajenlab.common.service.process.state.State#setProcessInstance(li.rajenlab.common.domain.process.ProcessInstance)
     */
    public void setProcessInstance(ProcessInstance instance) {
        this.processInstance_ = instance;
    }

    /**
     * Get the Event.
     *
     * @return the Event.
     */
    public Event getEvent() {
        return event_;
    }

    /**
     * Get the Process.
     *
     * @return the Process.
     */
    public Process getProcess() {
        return process_;
    }
    
    
    /**
     * @return the processInstance
     */
    public ProcessInstance getProcessInstance() {
        return this.processInstance_;
    }

    /**
     * Check that the Process and Event are set.
     */
    protected void checkParameters() {
        if (process_ == null) {
            throw new RuntimeException("Process missing");
        }

        if (event_ == null) {
            throw new RuntimeException("Event missing");
        }
        
    }

    protected void logTransitionMethod( String method ) {
        String processName = ( getProcess() != null ) ? getProcess().getName() : "Unknown Process";
        String oid = ( getProcessInstance() != null ) ? getProcessInstance().getOid() : "Unknown oid";
        log.debug(method + " [" + processName + ":" + getName() + ":" + oid);
    }
}
