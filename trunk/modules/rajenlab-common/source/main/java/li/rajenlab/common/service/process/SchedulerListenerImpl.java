/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process;

import java.util.List;

import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;
import li.rajenlab.common.service.event.EventProcessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A SchedulerListener implementation which combines the
 * onTimer processing with dispatching via EventProcessor.
 * 
 * A "Spring" hack to remove the "cyclic" dependency of 
 * StatefullProcessImpl on EventProcessor which itself
 * depends on processes ( via the EventDispatcher chains ).
 * 
 * The SchedulerListenerImpl must be wrapped in a transaction
 * proxy and have "REQUIRES_NEW" transaction semantics on the
 * onTimer method.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SchedulerListenerImpl implements SchedulerListener {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(SchedulerListenerImpl.class);

    private SchedulerListener delegateListener_;
    private EventProcessor eventProcessor_;
    
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

	
	/**
	 * @see li.rajenlab.common.service.process.SchedulerListener#getReadyTimers(int)
	 */
	public List<ProcessTimer> getReadyTimers(int maxTimers) {
		return getDelegateListener().getReadyTimers(maxTimers);
	}

	/**
     * 
     * @see li.rajenlab.common.service.process.SchedulerListener#onTimer(li.rajenlab.common.domain.process.ProcessInstance)
	 */
	public void onTimer(ProcessInstance instance) {
		getDelegateListener().onTimer(instance);
		if ( getEventProcessor() != null ) {
			getEventProcessor().process();
		}
	}

	/**
     * 
     * @see li.rajenlab.common.service.process.SchedulerListener#getMaxTimersPerSchedule()
	 */
	public int getMaxTimersPerSchedule() {
		return getDelegateListener().getMaxTimersPerSchedule();
	}

	/**
     * 
     * @see li.rajenlab.common.service.process.SchedulerListener#getMaxTimersPerSelect()
	 */
	public int getMaxTimersPerSelect() {
		return getDelegateListener().getMaxTimersPerSelect();
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
	 * @return Returns the delegateListener.
	 */
	public SchedulerListener getDelegateListener() {
		return delegateListener_;
	}

	/**
	 * @param delegateListener The delegateListener to set.
	 */
	public void setDelegateListener(SchedulerListener delegateListener) {
		this.delegateListener_ = delegateListener;
	}

	/**
	 * @return Returns the eventProcessor.
	 */
	public EventProcessor getEventProcessor() {
		return eventProcessor_;
	}

	/**
	 * @param eventProcessor The eventProcessor to set.
	 */
	public void setEventProcessor(EventProcessor eventProcessor) {
		this.eventProcessor_ = eventProcessor;
	}

}
