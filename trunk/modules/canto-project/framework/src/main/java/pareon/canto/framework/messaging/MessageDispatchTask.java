package pareon.canto.framework.messaging;

public class MessageDispatchTask implements Runnable {

	private	ThreadPoolMessageEngine	messageEngine;
	private	MessagingEvent			event;
	private	MessagingEventReceiverFilter	filter;
	private	String[]			excludeReceiver;
	private	String[]			includeReceiver;
	
	public MessageDispatchTask(ThreadPoolMessageEngine messageEngine,
			MessagingEvent event, String[] includeReceiver, String[]excludeReceiver) {
		this.messageEngine = messageEngine;
		this.event = event;
		this.includeReceiver = includeReceiver;
		this.excludeReceiver = excludeReceiver;
	}
	
	public MessageDispatchTask(ThreadPoolMessageEngine messageEngine,
				MessagingEvent event, MessagingEventReceiverFilter filter) {
		this.messageEngine = messageEngine;
		this.event = event;
		this.filter = filter;
	}
	
	public void run() {
		try {
			if (excludeReceiver != null) {
				messageEngine.realDispatchEventToAllExcept(event,excludeReceiver);
			} else if (includeReceiver != null) {
				messageEngine.realDispatchEventToReceiver(event,includeReceiver);
			} else if (filter != null) {
				messageEngine.realDispatchEvent(event,filter);
			} else {
				messageEngine.realDispatchEvent(event);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
