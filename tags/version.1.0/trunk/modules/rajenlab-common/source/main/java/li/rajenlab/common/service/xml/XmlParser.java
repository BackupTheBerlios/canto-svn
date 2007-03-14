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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import li.rajenlab.common.system.EnvironmentSupport;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public final class XmlParser {
    
    public static URL DEFAULT_VALIDATION_DIRECTORY_URL;
    public static final String propertyFileName = "li/rajenlab/common/service/xml/XmlParser.properties";
    public static final String dtdDirPropertyName = "xmlparser.dtd.dir";
    
    static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream( propertyFileName );
		if ( is == null ) {
			throw new RuntimeException("Unable to load resource: " + propertyFileName);
		}
		Properties properties = new Properties();
		try {
			properties.load(is);
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
    	
        try {
        	String dtdDir = properties.getProperty(dtdDirPropertyName);
        	if ( dtdDir == null ) {
        		throw new RuntimeException("Missing property " + dtdDirPropertyName + " in file " + propertyFileName);
        	}
        	dtdDir = EnvironmentSupport.expandVars(dtdDir); // expand JBOSS_SERVER
            DEFAULT_VALIDATION_DIRECTORY_URL = new File (dtdDir).toURL ();
        } catch ( MalformedURLException ex ) {
            throw new RuntimeException("Cannot assign DEFAULT_VALIDATION_DIRECTORY_URL", ex);
        }
    }
	
    public static Document parse (final String xml) throws Exception {
        return parse (xml, DEFAULT_VALIDATION_DIRECTORY_URL.toString());
    }
    
    public static Document parse (final String xml, String systemIdUrl) throws Exception {
        SAXReader reader = new SAXReader();
        reader.setMergeAdjacentText(true);

        InputSource is = new InputSource(new StringReader(xml));
        is.setSystemId(systemIdUrl);
        
        Document doc = reader.read(is);
        return doc;
    }
    
    
    public static Document parse (final byte[] xml, String systemIdUrl) throws Exception {
        SAXReader reader = new SAXReader();
        reader.setMergeAdjacentText(true);
        
        // TODO do we need to use an InputStreamReader, or can we just use the ByteArrayInputStream directly?
        InputSource is = new InputSource(new InputStreamReader (new ByteArrayInputStream (xml)));
        is.setSystemId(systemIdUrl);

        Document doc = reader.read (is);
        return doc;
    }

    public static Document parse (final byte[] xml) throws Exception {
        return parse(xml, DEFAULT_VALIDATION_DIRECTORY_URL.toString());
    }

    public static Document parse (
            final byte[] xml,
            final String systemIdUrl,
            final String encoding)
        throws Exception
    {
        SAXReader reader = new SAXReader ();
        reader.setMergeAdjacentText (true);

        InputSource is = new InputSource (new ByteArrayInputStream (xml));
        is.setSystemId (systemIdUrl);
        is.setEncoding (encoding);

        return reader.read (is);
    }

    public static Document parse (final File aFile, String systemIdUrl) throws Exception {
        SAXReader reader = new SAXReader();
        
        InputSource is = new InputSource(new FileInputStream(aFile));
        is.setSystemId(systemIdUrl);

        Document doc = reader.read (is);
        return doc;
    }

    public static Document parse (final File aFile) throws Exception {
        return parse(aFile, DEFAULT_VALIDATION_DIRECTORY_URL.toString());
    }
    
}
