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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DateTimeFormatter that uses exactly one date format for parsing and 
 * formatting dates. The format string must be supplied using the 
 * constructor.
 * 
 * @see java.text.SimpleDateFormat
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class SimpleDateTimeFormatter implements DateTimeFormatter {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(SimpleDateTimeFormatter.class);
    
    private SimpleDateFormat dateFormat_;

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    
    public SimpleDateTimeFormatter(String dateFormat) {
        dateFormat_ = new SimpleDateFormat(dateFormat);
        dateFormat_.setLenient(false);
    }

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    public String format(Date date) {
        return dateFormat_.format(date);
    }

    public Date parse(String date) throws ParseException {
        return dateFormat_.parse(date);
    }

    //-------------------------------------------------------------------------
    //PROTECTED METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PRIVATE METHODS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PUBLIC ACCESSORS (GETTERS / SETTERS)
    //-------------------------------------------------------------------------

}
