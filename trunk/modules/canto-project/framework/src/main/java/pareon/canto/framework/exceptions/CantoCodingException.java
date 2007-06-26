/**
 * 
 */
package pareon.canto.framework.exceptions;

/**
 * @author tzhrora2
 *
 */
public class CantoCodingException extends Exception {
	
	
	public CantoCodingException(String message){
		super(message);
	}
	
	public CantoCodingException(String message, Throwable cause){
		super(message, cause);
	}

}
