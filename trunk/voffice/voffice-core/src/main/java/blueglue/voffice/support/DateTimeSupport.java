package blueglue.voffice.support;

import java.util.Calendar;
import java.util.Date;

public abstract class DateTimeSupport {

	
	private DateTimeSupport(){
		
	}
	
	/**
	 * Check if the current time is after the expiry time
	 * @param time
	 * @return
	 */
	public static boolean isDateExpired(Date time){
		
		if (time==null){
			return false;
		}
		
		Calendar currentTime = Calendar.getInstance();
		Calendar expiryTime = Calendar.getInstance();
		expiryTime.setTime(time);
		return currentTime.after(expiryTime);
	}
}
