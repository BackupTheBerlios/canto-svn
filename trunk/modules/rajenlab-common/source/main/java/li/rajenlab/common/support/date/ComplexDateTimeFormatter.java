/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/
package li.rajenlab.common.support.date;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ComplexDateTimeFormatter formats and parses a Date ( with Time information ) according
 * to the most specific format which applies. 
 * 
 * Not ThreadSafe. Callers must make sure that not more than one thread at
 * a time is calling the ComplexDateTimeFormatter. Or use the threadsafe
 * wrapper {@link ThreadSafeDateTimeFormatter}.
 * 
 * millis:  yyyy-MM-dd HH:mm:ss.S
 * seconds: yyyy-MM-dd HH:mm:ss
 * minutes: yyyy-MM-dd HH:mm
 * days:    yyyy-MM-dd
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ComplexDateTimeFormatter implements DateTimeFormatter {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ComplexDateTimeFormatter.class);

	private DateTimeFormatSpecification dfs_;
	
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

	public ComplexDateTimeFormatter( DateTimeFormatSpecification df ) {
		dfs_ = df;
	}
	
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    
	/**
	 * Tries to parse the date string to the most specific formatter.
     * @see sunrise.xip.common.support.date.DateTimeFormatter#parse(String)
	 */
	public Date parse( String date ) throws ParseException {
		if ( date == null ) {
			return null;
		}
		Date lessSpecificDate = null;
		Date moreSpecificDate = null;
		
		lessSpecificDate = tryParse( date, dfs_.getDaysFormat() );
		moreSpecificDate = tryParse( date, dfs_.getMinutesFormat() );
		
		if ( moreSpecificDate != null ) {
			lessSpecificDate = moreSpecificDate;
			moreSpecificDate = tryParse( date, dfs_.getSecondsFormat() );
			if ( moreSpecificDate != null ) {
				lessSpecificDate = moreSpecificDate;
				moreSpecificDate = tryParse( date, dfs_.getMillisFormat() );
				if ( moreSpecificDate != null ) {
					return moreSpecificDate;
				} else {
					return lessSpecificDate;
				}
			} else {
				return lessSpecificDate;
			}
		} else if ( lessSpecificDate == null ) {
			throw new ParseException(date, 0);
		}
		return lessSpecificDate;
	}
	
	/**
	 * Tries to format the date to the most specific format, whilst reducing
	 * the format according to the {@link DateTimeFormatSpecification#getReduceTimeToField()}
     * @see sunrise.xip.common.support.date.DateTimeFormatter#format(Date)
	 * 
	 * @param date
	 * @return the formatted date.
	 */
	public String format( Date date ){
		if ( date == null ) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int millis  = calendar.get( Calendar.MILLISECOND );
		int seconds = calendar.get( Calendar.SECOND );
		int minutes = calendar.get( Calendar.MINUTE );
		int hours   = calendar.get( Calendar.HOUR );

		if ( millis == 0 && seconds == 0 && minutes == 0 && hours == 0 ) {
			return dfs_.getDaysFormat().format(date);
		} else if ( millis == 0 && seconds == 0 ) {
			return dfs_.getMinutesFormat().format(date);
		} else if ( millis == 0 ) {
			return dfs_.getSecondsFormat().format(date);
		} else {
			return dfs_.getMillisFormat().format(date);
		}
	}
	
	/**
	 * Show most specific format pattern.
	 */
	@Override
    public String toString() {
		return dfs_.getMillisFormat().toPattern();
	}
	
    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

	private Date tryParse( String date, SimpleDateFormat sdf ) {
		try {
			Date d = sdf.parse(date);
			return d;
		} catch ( ParseException pe ) {
		}
		return null;
	}

	//-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

	
}
