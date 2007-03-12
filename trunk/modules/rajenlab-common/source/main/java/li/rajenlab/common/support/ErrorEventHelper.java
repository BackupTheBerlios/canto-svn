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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import li.rajenlab.common.domain.errorhandler.ErrorEvent;

/**
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class ErrorEventHelper {
    
    public static ErrorEvent createErrorEvent( String module,String category, String subcategory, String reference, String detail ) {
        ErrorEvent event = new ErrorEvent();
        event.setModule(module);
        event.setCategory(category);
        event.setSubcategory(subcategory);
        event.setReference(reference);
        event.setDetail(detail);
        event.setTimestamp(new Date());
        return event;
    }
    
    public static ErrorEvent createErrorEvent( String module,String category, String subcategory, String reference ) {
        ErrorEvent event = new ErrorEvent();
        event.setModule(module);
        event.setCategory(category);
        event.setSubcategory(subcategory);
        event.setReference(reference);
        event.setTimestamp(new Date());
        return event;
    }
    
    public static void fillInStackTrace( ErrorEvent event, Exception exception ) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        
        event.setStacktrace(sw.toString());
    }

}
