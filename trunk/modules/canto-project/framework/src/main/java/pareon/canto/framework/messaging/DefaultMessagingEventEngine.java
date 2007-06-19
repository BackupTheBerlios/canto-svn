package pareon.canto.framework.messaging;

/**
 * This Engine is intended for use when the number of receivers for
 * any single event at a time is not expected to exceed 30.
 * @author tzhrora2
 *
 */
public class DefaultMessagingEventEngine extends BaseMessagingEventEngine {
	
	public static final int DEFAULT_MAX_RECEIVERS = 30;
	
	private int maxReceivers = DEFAULT_MAX_RECEIVERS;
	
	
	@Override
	public void checkAddEventReceiver() throws MaxReceiverReachedException {
		int	size = receiversMap.size();
		if (size > maxReceivers){
			String logMessage = "Total of receivers ["+size+"] has reached the max of ["+maxReceivers+"]";
			logger.warn(logMessage);
			throw new MaxReceiverReachedException(logMessage);
		}
	}

		/**
	 * get Max Receivers
	 * @return
	 */
	public int getMaxReceivers() {
		return maxReceivers;
	}

	/**
	 * Set MaxReceivers
	 * @param maxReceivers
	 */
	public void setMaxReceivers(int maxReceivers) {
		this.maxReceivers = maxReceivers;
	}
	
	

	
}
