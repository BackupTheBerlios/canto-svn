/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 * 
 * 
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.xml;


import java.io.ByteArrayOutputStream;

import org.dom4j.Branch;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public final class XmlWriter {
    
    public final static int DEFAULT_INDENTATION = 4;
    public final static String DEFAULT_ENCODING = "ISO-8859-1";

    public static String formatToString( Branch aBranch ) {
    	try {
    		String result = new String(format(aBranch), DEFAULT_ENCODING);
    		return result;
    	} catch ( Exception e ) {
    		throw new RuntimeException(e);
    	}
    }
    
    public static byte[] format ( Branch aBranch )
    {
    	return format (aBranch, DEFAULT_ENCODING);
    }

    public static byte[] format ( Branch aBranch, String anEncoding)
    {
        return format (true, true, DEFAULT_INDENTATION, aBranch, anEncoding);
    }

    public static String formatToString( 
    		final boolean includesXmlHeader,
            final boolean canPrettyPrint,
            final int indentation,
            final Branch aBranch) {
    	try {
    		String result = new String(format(includesXmlHeader, canPrettyPrint, indentation, aBranch, DEFAULT_ENCODING), DEFAULT_ENCODING);
    		return result;
    	} catch ( Exception e ) {
    		throw new RuntimeException(e);
    	}
    }
    
    public static byte[] format (
            final boolean includesXmlHeader,
            final boolean canPrettyPrint,
            final int indentation,
            final Branch aBranch,
            final String anEncoding)
    {
    	try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream ();
	
	        OutputFormat of = new OutputFormat ();
	        of.setEncoding (anEncoding);
	        of.setExpandEmptyElements (true);
	        of.setIndent (canPrettyPrint);
	        of.setIndentSize (canPrettyPrint ? indentation : 0);
	        of.setNewlines (canPrettyPrint);
	        of.setTrimText (canPrettyPrint);
	        of.setSuppressDeclaration (!includesXmlHeader);
	        of.setOmitEncoding (!includesXmlHeader);
	
	        XMLWriter xw = new XMLWriter (baos, of);
	        xw.write (aBranch);
	        xw.flush ();
	
	        return baos.toByteArray ();
    	} catch ( Exception e ) {
    		throw new RuntimeException(e);
    	}
    }
}