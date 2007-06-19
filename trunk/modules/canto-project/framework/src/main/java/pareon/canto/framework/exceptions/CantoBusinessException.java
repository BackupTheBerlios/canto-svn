package pareon.canto.framework.exceptions;

public class CantoBusinessException extends Exception {
	
	
	public CantoBusinessException(String message){
		super(message);
	}
	
	public CantoBusinessException(String message, Throwable cause){
		super(message, cause);
	}

}
