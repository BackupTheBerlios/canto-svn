package pareon.canto.framework.messaging;

import pareon.canto.framework.exceptions.CantoBusinessException;

public class MaxReceiverReachedException extends CantoBusinessException {
	
	
	public MaxReceiverReachedException(String message){
		super(message);
	}

}
