package pareon.canto.framework.messaging;

public interface MessagingEventEngine {
	
	/**
	 * Dispatch an event
	 * @param event
	 */
	public	abstract void dispatchEvent(MessagingEvent event);
	
	/**
	 * Dispatch an event to a specific receiver id(s)
	 * @param event
	 * @param onlyToReceiverWithId
	 */
	public	abstract void dispatchEventToReceiver(MessagingEvent event, String... onlyToReceiverWithId);
	
	/**
	 * Dispatch an event to all except the receiver id(s)
	 * @param event
	 * @param excludeReceiverWithId
	 */
	public	abstract void dispatchEventToAllExcept(MessagingEvent event, String... excludeReceiverWithId);
	
	/**
	 * Dispatch an event based on the filter
	 * @param event
	 * @param filter
	 */
	public	abstract void dispatchEvent(MessagingEvent event, MessagingEventReceiverFilter filter);
	
	/**
	 * Add the receiver to receive all events.
	 * @param receiver the event receiver.
	 */
	public	abstract void addEventReceiver(MessagingEventReceiver receiver)
		throws MaxReceiverReachedException;
	
	/**
	 * Remove the receiver to receive events
	 * @param receiver
	 */
	public	abstract void removeEventReceiver(MessagingEventReceiver receiver);

}
