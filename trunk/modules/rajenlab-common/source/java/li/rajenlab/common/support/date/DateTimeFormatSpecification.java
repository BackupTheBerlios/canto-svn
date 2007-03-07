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

import java.text.SimpleDateFormat;

/**
 * DateTimeFormatSpecification is a DateFormatter interface to be used 
 * in conjunction with ComplexDateTimeFormatter.
 * 
 * A DateTimeFormatSpecification provides multiple dateformats for different
 * time resolutions.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class DateTimeFormatSpecification {

    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

	public static final String STANDARD_TIMESTAMP_FORMAT   = "dd.MM.yyyy HH:mm:ss.S";
	public static final String STANDARD_DATETIME_FORMAT    = "dd.MM.yyyy HH:mm:ss";
	public static final String STANDARD_DATEMINUTES_FORMAT = "dd.MM.yyyy HH:mm";
	public static final String STANDARD_DATE_FORMAT        = "dd.MM.yyyy";
	
    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
	private SimpleDateFormat millis_;
	private SimpleDateFormat seconds_;
	private SimpleDateFormat minutes_;
	private SimpleDateFormat days_;
	
    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------

	/**
	 * DateTimeFormatSpecification based on XIP standard date time formats.
	 * 
	 * Uses {@link #STANDARD_DATE_FORMAT} for day format.
	 * Uses {@link #STANDARD_DATEMINUTES_FORMAT} for minutes format.
	 * Uses {@link #STANDARD_DATETIME_FORMAT} for seconds format.
	 * Uses {@link #STANDARD_TIMESTAMP_FORMAT} for millis format.
	 */
	public DateTimeFormatSpecification() {
		this(STANDARD_DATE_FORMAT,STANDARD_DATEMINUTES_FORMAT,STANDARD_DATETIME_FORMAT,STANDARD_TIMESTAMP_FORMAT);
	}
	
	/**
	 * DateTimeFormatSpecification based on provided date time formats.
	 * 
	 * @param dayFormat
	 * @param minFormat
	 * @param secFormat
	 * @param msFormat
	 */
	public DateTimeFormatSpecification(String dayFormat, String minFormat, String secFormat, String msFormat) {
		millis_  = new SimpleDateFormat( msFormat );
		millis_.setLenient(false);
		seconds_ = new SimpleDateFormat( secFormat );
		seconds_.setLenient(false);
		minutes_ = new SimpleDateFormat( minFormat );
		minutes_.setLenient(false);
		days_    = new SimpleDateFormat( dayFormat );
		days_.setLenient(false);
	}
	
    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------
    
	/**
	 * A millisecond format, i.e. yyyy-MM-dd HH:mm:ss.S
	 * @return a millisecond format.
	 */
	public SimpleDateFormat getMillisFormat() {
		return millis_;
	}

	/**
	 * A second format, i.e. yyyy-MM-dd HH:mm:ss
	 * @return a second format.
	 */
	public SimpleDateFormat getSecondsFormat() {
		return seconds_;
	}

	/**
	 * A minute format, i.e. yyyy-MM-dd HH:mm
	 * @return a minute format.
	 */
	public SimpleDateFormat getMinutesFormat() {
		return minutes_;
	}

	/**
	 * A day format, i.e. yyyy-MM-dd
	 * @return a day format.
	 */
	public SimpleDateFormat getDaysFormat() {
		return days_;
	}	
}
