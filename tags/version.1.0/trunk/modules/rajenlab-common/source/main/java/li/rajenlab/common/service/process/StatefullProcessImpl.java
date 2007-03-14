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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import li.rajenlab.common.dao.process.ProcessInstanceDAO;
import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.domain.event.contenthandler.ObjectContentHandler;
import li.rajenlab.common.domain.process.ProcessInstance;
import li.rajenlab.common.domain.process.ProcessTimer;
import li.rajenlab.common.service.process.state.State;
import li.rajenlab.common.service.process.state.StateFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;


public class StatefullProcessImpl extends BaseProcess implements StatefullProcess {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------

    protected static Log log = LogFactory.getLog(StatefullProcessImpl.class);
    
	private String attachmentName_;
	private StateFactory stateFactory_;
	
	private ProcessInstanceDAO processInstanceDAO_;
	
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

	
	/**
	 * @see li.rajenlab.common.domain.event.EventListener#onEvent(li.rajenlab.common.domain.event.Event)
	 */
	public void onEvent(Event event) {
		if ( event == null ) {
			throw new RuntimeException("event is null");
		}
		Attachment mapAttachment = event.getAttachment(getAttachmentName());
		if ( mapAttachment == null ) {
			throw new RuntimeException("mapAttachment is not found with name " + getAttachmentName());
		}
		String oid = mapAttachment.getProperty(EventMapper.PROPERTY_OID);
		if ( oid == null ) {
			throw new RuntimeException("oid is not found in attachment " + mapAttachment);
		}
		String methodName = mapAttachment.getProperty(EventMapper.PROPERTY_METHOD);
		if ( methodName == null ) {
			throw new RuntimeException("methodName is not found in attachment " + mapAttachment);
		}
		ProcessInstance processInstance = getProcessInstanceDAO().findByOid( getName(), oid );
		if ( processInstance == null ) {
			String initialStateName = getStateFactory().getInitialState().getName();
			
			processInstance = new ProcessInstance();
			processInstance.setStateName( initialStateName );
			processInstance.setOid(oid);
			processInstance.setProcessName(getName());
			
			// persist the "empty" process instance
			getProcessInstanceDAO().save(processInstance);
			
			// call onEntry explicitly on the initial state.
			State initialState = setupState(initialStateName, event, processInstance);
			initialState.onEntry();
		} else {
			processInstance = getProcessInstanceDAO().refresh(processInstance, LockMode.UPGRADE);
		}
		
		// process the event
		processEvent( event, processInstance, methodName );
	}

	/**
	 * A periodic scheduler thread calls the getReadyTimer() method.
	 * 
	 * This method must not have a transactional context setup.
	 */
	public List<ProcessTimer> getReadyTimers( int maxTimers ) {
		log.debug( "getReadyTimers("+maxTimers+") called.");
		List<ProcessTimer> timersReady = getProcessInstanceDAO().findByTimerReady(getName(), maxTimers);
		return timersReady;
	}

	/**
	 * Handle a ProcessTimer popping. 
	 * 
	 * A Scheduler will retrieve a list of ProcessTimers which are ready to pop
	 * with {@link #getReadyTimers(int)} and for each timer call this method.
	 * 
	 * This method must have a NEW transactional context setup for each call.
	 * 
	 * Any Events created in the context of onTimer must also be processed
	 * by calling EventProcessor#process()
	 * 
	 * @param instance the ProcessInstance which has a timer which is ready to pop.
	 */
	public void onTimer( ProcessInstance instance ) {
		ProcessTimer timer = instance.getTimer(); 
		
		// try and get a nowait upgrade lock on the instance
		// the timer could already have been pinched by another process
		ProcessInstance processInstance = getProcessInstanceDAO().refresh(instance, LockMode.UPGRADE_NOWAIT);
		if ( processInstance == null ) {
			// some other instance in the cluster got to him first
			// go on with the next one....
			log.info("Process instance timer was currently locked!");
			return;
		}
		if ( processInstance.getTimer() == null || !timer.getTimerId().equals(processInstance.getTimer().getTimerId()) ) {
			// timer unset in the meantime by another cluster member
			log.info("Process instance timer already reset.");
			return;
		}
		// construct a timer event which will be passed to a State's timer method.
		// it can be used to determine when the timer "should" have triggered.
		Event timerEvent = setupTimerEvent(timer);
		
		// process the timer event
		processEvent( timerEvent, processInstance, getStateFactory().getTimerMethodName() );
	}
	
	/**
	 * Subclass this if you want to do one time setup on initilization.
	 * Make sure the Spring configuration for the Process has
	 * init-method="onBoot" set.
	 */
	public void onBoot() {
		log.info("onBoot called on Process " + getName());
	}

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

	protected void processEvent( Event event, ProcessInstance processInstance, String methodName ) {
		// clear the timer
		processInstance.setTimer(null);
		
		// call the onExit method of the old state.
		String oldStateName = processInstance.getStateName();
		State oldState = setupState(oldStateName, event, processInstance);
		oldState.onExit();
		
		// transition
		callStateMethod(oldState, methodName);
		
		// call the onEntry method in the new state.
		String newStateName = processInstance.getStateName();
		State newState = setupState(newStateName, event, processInstance);
		newState.onEntry();
		
		if ( getStateFactory().getFinalState() != null && getStateFactory().getFinalState().getName().equals( processInstance.getStateName() )) {
			//TODO archive
			log.info("Deleting " + processInstance);
			getProcessInstanceDAO().delete(processInstance);
		} else {
			log.info("Saving " + processInstance);
			getProcessInstanceDAO().save(processInstance);
		}
	}
	
	/**
	 * Call an already setup State given it's method name.
	 * 
	 * @see #setupState(String, Event, ProcessInstance)
	 */
	protected void callStateMethod( State state, String methodName ) {
		try {
			Method method = state.getClass().getMethod(methodName, new Class[0]);
			method.invoke(state, new Object[0]);
		} catch ( NoSuchMethodException nsme ) {
			// nothing to be done in this case!
			// TODO make this a configurable behaviour !
			log.info("State " + state.getName() + " does not implement method " + methodName, nsme);
		} catch ( IllegalAccessException iae ) {
			throw new RuntimeException(iae);
		} catch ( InvocationTargetException ite ) {
			throw new RuntimeException(ite);
		}
	}
	
	/**
	 * Construct a State given the stateName and populate the
	 * Event and ProcessInstance in the State.
	 * 
	 * @param stateName the State's name
	 * @param event the Event.
	 * @param processInstance the ProcessInstance.
	 * @return a setup State.
	 */
	protected State setupState(String stateName, Event event, ProcessInstance processInstance) {
		State state = getStateFactory().getState(stateName);
		
		state.setEvent(event);
		state.setProcess(this);
		state.setProcessInstance(processInstance);
		
		return state;
	}
	
	/**
	 * Create an Event from the ProcessTimer.
	 * 
	 * @param timer the ProcessTimer.
	 * 
	 * @return the Event.
	 */
	protected Event setupTimerEvent( ProcessTimer timer ) {
        Event timerEvent = new Event();
        Attachment reqAttachment = new Attachment(new ObjectContentHandler(
                    timer));
        timerEvent.addAttachment(StandardEventProperties.REQUEST_ATTACHMENT_NAME,
            reqAttachment);
        return timerEvent;
	}
	
    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

	public ProcessInstanceDAO getProcessInstanceDAO() {
		return processInstanceDAO_;
	}

	public void setProcessInstanceDAO(ProcessInstanceDAO processInstanceDAO) {
		this.processInstanceDAO_ = processInstanceDAO;
	}

	/**
     * 
     * @see li.rajenlab.common.service.process.StatefullProcess#getStateFactory()
	 */
	public StateFactory getStateFactory() {
		return stateFactory_;
	}

	public void setStateFactory(StateFactory stateFactory) {
		this.stateFactory_ = stateFactory;
	}

	public String getAttachmentName() {
		return attachmentName_;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName_ = attachmentName;
	}
}
