/**
 * 
 */
package pareon.canto.framework.support;

import java.util.Calendar;
import java.util.Date;

/**
 * @author tzhrora2
 *
 */
public abstract class DateTimeUtils {
	
	
	private DateTimeUtils(){
		
	}
	
	
	public static boolean isDateInThePast(Date time){
		if (time==null){
			return false;
		}
		
		Calendar expiryCal = Calendar.getInstance();
		expiryCal.setTime(time);
		
		Calendar currentCal = Calendar.getInstance();
		return currentCal.after(expiryCal);
	}

}
