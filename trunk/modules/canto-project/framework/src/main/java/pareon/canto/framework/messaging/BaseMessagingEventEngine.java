package pareon.canto.framework.messaging;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Base class of all implementation of MessagingEventEngine
 * @author tzhrora2
 *
 */
public abstract class BaseMessagingEventEngine implements MessagingEventEngine {

	protected Log logger = LogFactory.getLog(getClass());
	
	protected HashMap<String, MessagingEventReceiver>	receiversMap;
	
	
	public BaseMessagingEventEngine(){
		receiversMap = new HashMap<String, MessagingEventReceiver>();
	}
	
	/**
	 * Add Event Receiver
	 */
	public synchronized final void addEventReceiver(MessagingEventReceiver receiver) 
		throws MaxReceiverReachedException {
		checkAddEventReceiver();
		if (!receiversMap.containsKey(receiver.getId())) {
			receiversMap.put(receiver.getId(),receiver);
			logger.info("MessagingEventReceiver ["+receiver.getId()+"] added");
		}

	}
	
	/**
	 * Remove Event Receiver
	 */
	public synchronized final void removeEventReceiver(MessagingEventReceiver receiver) {
		receiversMap.remove(receiver.getId());
		logger.info("MessagingEventReceiver ["+receiver.getId()+"] removed");
	}
	
	/**
	 * Dispatch event to receivers which are accepted by filter
	 */
	public final void dispatchEvent(MessagingEvent event,
			MessagingEventReceiverFilter filter) {
		doDispatchEvent(event, filter);
	}

	/**
	 * Dispatch event to all receivers
	 */
	public final void dispatchEvent(MessagingEvent event) {
		doDispatchEvent(event);
		
	}

	/**
	 * Dispatch event to a list of receivers that are not in the list
	 */
	public final void dispatchEventToAllExcept(MessagingEvent event,
			String... excludeReceiverWithId) {
		doDispatchEventToAllExcept (event,excludeReceiverWithId);
	}

	/**
	 * Dispatch event to a list of receivers
	 */
	public final void dispatchEventToReceiver(MessagingEvent event,
			String... onlyToReceiverWithId) {
		doDispatchEventToReceiver(event,onlyToReceiverWithId);
		
	}
	

	/**
	 * Check AddEventReceiver, in case of a failure the method should throws an exception of 
	 * type MaxReceiverReachedException. Implementation
	 * by subclass
	 */
	public abstract void checkAddEventReceiver() throws MaxReceiverReachedException;
	
	
	/**
	 * Check if a specific id is in the list
	 * @param receiverIdToCheck
	 * @param receiverIdsList
	 * @return
	 */
	protected final boolean receiverIdInList(String receiverIdToCheck, String...receiverIdsList){
		for (int i=0;i<receiverIdsList.length;i++){
			if (receiverIdToCheck.equals(receiverIdsList[i])){
				return true;
			}
		}
		
		return false;
	}

	
	/**
	 * Dispatch event to receivers which are accepted by filter, can override by the subclass
	 */
	protected void doDispatchEvent(MessagingEvent event,
			MessagingEventReceiverFilter filter) {
		for (MessagingEventReceiver ier : receiversMap.values()){
			if (filter != null && filter.sendEventTo(ier,event)) {
				ier.receiveEvent(event);
				logger.info("doDispatchEventWithFilter(): Dispatch event ["+event.getEventKey()+ "] " +
						"MessagingEventReceiver ["+ier.getId()+"]");
			}
		}
	}

	/**
	 * Dispatch event to all receivers, can override by the subclass
	 */
	protected void doDispatchEvent(MessagingEvent event) {
		for (MessagingEventReceiver ier : receiversMap.values()){
			ier.receiveEvent(event);
			logger.info("doDispatchEvent(): Dispatch event ["+event.getEventKey()+ "] " +
					"MessagingEventReceiver ["+ier.getId()+"]");
		}
		
	}

	/**
	 * Dispatch event to a list of receivers that are not in the list, can override by the subclass
	 */
	protected void doDispatchEventToAllExcept(MessagingEvent event,
			String... excludeReceiverWithId) {
		for (MessagingEventReceiver ier : receiversMap.values()){
			if (!receiverIdInList(ier.getId(),excludeReceiverWithId)) {
				ier.receiveEvent(event);
				logger.info("doDispatchEventToAllExcept(): Dispatch event ["+event.getEventKey()+ "] " +
						"MessagingEventReceiver ["+ier.getId()+"]");
			}
		}
	}

	/**
	 * Dispatch event to a list of receivers, can override by the subclass
	 */
	protected void doDispatchEventToReceiver(MessagingEvent event,
			String... onlyToReceiverWithId) {
		for (MessagingEventReceiver ier : receiversMap.values()){
			if (receiverIdInList(ier.getId(),onlyToReceiverWithId)) {
				ier.receiveEvent(event);
				logger.info("doDispatchEventToReceiver(): Dispatch event ["+event.getEventKey()+ "] " +
						"MessagingEventReceiver ["+ier.getId()+"]");
			}
		}
		
	}
}
