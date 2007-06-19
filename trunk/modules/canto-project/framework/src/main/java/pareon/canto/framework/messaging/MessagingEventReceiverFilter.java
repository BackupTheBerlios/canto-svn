package pareon.canto.framework.messaging;

public interface MessagingEventReceiverFilter {
	
	
	/**
	 * Filter if the event can be send or not
	 * @param receiver
	 * @param event
	 * @return
	 */
	public	boolean		sendEventTo(MessagingEventReceiver receiver, MessagingEvent event);

}
