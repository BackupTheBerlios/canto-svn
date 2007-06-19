package pareon.canto.framework.messaging;

public interface MessagingEvent extends Comparable {
	
	public abstract String getEventKey();
	
	public abstract String getType();

	public abstract String getTarget();
	
	public abstract String getSource();
	
	public abstract String getSenderId();
	
}
