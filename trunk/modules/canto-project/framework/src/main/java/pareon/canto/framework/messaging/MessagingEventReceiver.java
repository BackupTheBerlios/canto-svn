package pareon.canto.framework.messaging;

/**
 * 
 * Each conference/meeting is expected to use one single
 * message engine to dispatch events to all its participants.
 * 
 * @author tzhrora2
 *
 */
public interface MessagingEventReceiver extends Comparable<MessagingEventReceiver> {
	
	/**
	 * Get the unique Id of the MessagingEventReceiver
	 * @return
	 */
	public	String	getId();
	
	/**
	 * Handle the received event
	 * @param event
	 */
	public	void	receiveEvent(MessagingEvent event);
	
	/**
	 * Set a filter
	 * @param eventFilter
	 */
	public	void	setEventFilter(MessagingEventFilter eventFilter);
	
	/**
	 * Remove the filter
	 */
	public	void	removeEventFilter();

}
