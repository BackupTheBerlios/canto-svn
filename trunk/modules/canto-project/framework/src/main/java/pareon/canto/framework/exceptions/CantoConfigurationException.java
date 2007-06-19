package pareon.canto.framework.exceptions;

public class CantoConfigurationException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1080186756809686895L;

	public CantoConfigurationException(String name){
		super(name);
	}
	
	public CantoConfigurationException(String name, Throwable cause){
		super(name, cause);
	}

}
