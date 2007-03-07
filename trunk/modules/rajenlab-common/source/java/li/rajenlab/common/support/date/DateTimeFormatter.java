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

/**
 * A DateTimeFormatter for parsing and formatting of Strings. 
 * Cannot be considered ThreadSafe.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface DateTimeFormatter {

    /**
     * Returns the string representation of a date.
     */
    public String format(Date date);
    
    /**
     * Tries to parse a date string.
     * @param date string possibly representing a date/time
     * @throws ParseException if the strings cannot be parsed 
     */
    public Date parse(String date) throws ParseException;
    
}
