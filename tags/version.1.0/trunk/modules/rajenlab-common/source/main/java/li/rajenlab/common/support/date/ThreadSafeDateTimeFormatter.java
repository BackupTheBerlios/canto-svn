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
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ThreadSafeDateTimeFormatter wraps a DateTimeFormatter and synchronizes
 * access to the delegates methods.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ThreadSafeDateTimeFormatter implements DateTimeFormatter {
    
    //-------------------------------------------------------------------------
    //PUBLIC CONSTANTS
    //-------------------------------------------------------------------------

    //-------------------------------------------------------------------------
    //PROTECTED AND PRIVATE VARIABLES AND CONSTANTS
    //-------------------------------------------------------------------------
    protected static Log log = LogFactory.getLog(ThreadSafeDateTimeFormatter.class);
    
    private DateTimeFormatter delegate_;

    //-------------------------------------------------------------------------
    //CONSTRUCTORS
    //-------------------------------------------------------------------------
    
    public ThreadSafeDateTimeFormatter(DateTimeFormatter delegate) {
    	delegate_ = delegate;
    }

    //-------------------------------------------------------------------------
    //PUBLIC METHODS
    //-------------------------------------------------------------------------

    public synchronized String format(Date date) {
        return delegate_.format(date);
    }

    public synchronized Date parse(String date) throws ParseException {
        return delegate_.parse(date);
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
