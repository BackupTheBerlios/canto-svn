/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.support;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import li.rajenlab.common.support.date.ComplexDateTimeFormatter;
import li.rajenlab.common.support.date.DateTimeFormatSpecification;
import li.rajenlab.common.support.date.DateTimeFormatter;
import li.rajenlab.common.support.date.SimpleDateTimeFormatter;
import li.rajenlab.common.support.date.ThreadSafeDateTimeFormatter;



/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class DateUtils {
    

    public static DateTimeFormatter createDateOnlyFormatter() {
    	return new SimpleDateTimeFormatter(DateTimeFormatSpecification.STANDARD_DATE_FORMAT);
    }

    public static DateTimeFormatter createDateTimeFormatter() {
    	return new SimpleDateTimeFormatter(DateTimeFormatSpecification.STANDARD_DATEMINUTES_FORMAT);
    }

    public static DateTimeFormatter createMultiDateTimeFormatter() {
    	return new ComplexDateTimeFormatter(new DateTimeFormatSpecification());
    }
	
    private static DateTimeFormatter singletonDateOnlyFormatter_;
    private static DateTimeFormatter singletonDateTimeFormatter_;
    private static DateTimeFormatter singletonMultiDateTimeFormatter_;
    static {
    	singletonDateOnlyFormatter_ = new ThreadSafeDateTimeFormatter(createDateOnlyFormatter());
    	singletonDateTimeFormatter_ = new ThreadSafeDateTimeFormatter(createDateTimeFormatter());
    	singletonMultiDateTimeFormatter_ = new ThreadSafeDateTimeFormatter(createMultiDateTimeFormatter());
    }
    
    public static DateTimeFormatter getDateOnlyFormatter() {
    	return singletonDateOnlyFormatter_;
    }

    public static DateTimeFormatter getDateTimeFormatter() {
    	return singletonDateTimeFormatter_;
    }

    public static DateTimeFormatter getMultiDateTimeFormatter() {
    	return singletonMultiDateTimeFormatter_;
    }
	
    
    
	public static Date normalizeTimestamp(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}
	
	public static Date normalizeDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}
	
    // clear h/min/s/ms
    public static Date normalizeDateFrom(Date from) {
    	return normalizeDate(from);
    }
    
    // clear h/min/s/ms and go to the next day -> compare with 'less' instead of 'less or equal' 
    public static Date normalizeDateTo(Date to) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(to);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }
    
    public static String getHourMinuteFromCalendar(Calendar cal){
        
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        
        StringBuffer sb = new StringBuffer();
        sb.append((hour < 10 ? "0" + String.valueOf(hour) : String.valueOf(hour)));
        sb.append(":");
        sb.append((minute < 10 ? "0" + String.valueOf(minute) : String.valueOf(minute)));
        return sb.toString();
    }
    
    public static Date addDaysToDate(Date startDate, Integer daysToAdd){
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, daysToAdd);
        return cal.getTime();
    }
    
    public static Date addDaysToCurrentDate(Integer daysToAdd){
        return addDaysToDate(new Date(),daysToAdd);
    }

    /**
     * Parse the date as string into date object
     * 
     * @param date
     * @return theDate
     * @throws ParseException
     */
    public static Date parseUIDate(String date) throws ParseException {
    	return getMultiDateTimeFormatter().parse(date);
    }

    /**
     * Format a date object
     * @param date
     * @return
     */
    public static String formatDateForUI(Date date){
    	return getMultiDateTimeFormatter().format(date);
    }
   
    
}
