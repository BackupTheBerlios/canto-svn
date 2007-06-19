package pareon.canto.framework.messaging;

public interface MessagingEventFilter {
	
	/**
	 * Filtering if the event can be received or not and then handle
	 * @param event
	 * @return
	 */
	public abstract boolean receiveEvent(MessagingEvent event);

}
