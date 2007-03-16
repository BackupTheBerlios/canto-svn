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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public final class XmlHelper {
    
    private static DocumentFactory factory = DocumentFactory.getInstance ();
    
    public static byte[] getBytes( String xml, String encoding ) {
    	try {
    		return xml.getBytes(encoding);
    	} catch ( UnsupportedEncodingException e ) {
    		throw new RuntimeException(e);
    	}
    }
    
    public static Document createDocument() {
        return factory.createDocument();
    }
    
    public static Document createDocument (final Element aRootElement) {
        return factory.createDocument (aRootElement);
    }
    
    public static Element createElement (final String anElementName) {
        return factory.createElement (anElementName);
    }
    
    public static String getRootElementName (final Document doc) {
        Element element = doc.getRootElement();
        if ( element == null ) {
            return "";
        }
        return element.getName();
    }
    
    public static String getElementValue (final String elementName, final Document document) {
        String searchXpath = "//" + elementName;

        Node node = document.selectSingleNode( searchXpath );
        if ( node == null ) {
            return "";
        }
        String val = node.getStringValue();
        
        return val == null ? "" : val;
    }

    public static String getSingleNodeText (final String anXpath, final Node aNode) {
        Node node = aNode.selectSingleNode (anXpath);

        if (node == null) {
            return "";
        }

        String val = node.getText ();
        
        return val == null ? "" : val;
    }
    
    /**
     * returns a childs element content as String
     * @param parent the parent Element
     * @param child name of the child to get the value from
     * @return value as string or if nothing found NULL
     */
    public static String getChildElementValue (final Element parent, final String child) {
        if ( parent == null ) {
            return null; 
        }
        Element childElement = parent.element(child);
        if(childElement != null) {
            return childElement.getStringValue();
        }
        return null;
    }

    public static String getAttributeValue (final String elementName, final String attName, final Document document ) {
        String searchXpath = "//"+elementName;
        
        Node node = document.selectSingleNode( searchXpath );
        if ( node == null ) {
            return "";
        }
        String val = node.valueOf( "@" + attName );
        
        return val == null ? "" : val;
    }

    public static String getAttributeValue (final Element element, final String attName) {
        String val = element.attributeValue(attName);
        
        return val == null ? "" : val;
    }

    /**
     * returns true if the xpath results in any of the following: 
     * a boolean with value true,
     * a list with a size > 0,
     * a Node (non null),
     * a String,
     * a Number.
     * Otherwise returns false.
     * This method improves the logic of matches, the method {@link XPath#matches(org.dom4j.Node)}
     * always returns false if the xpath query results in a Boolean value, whereas this method
     * returns the value of the boolean if the xpath query results in a Boolean value;
     * @param aNode
     * @param anXpath
     * @see #xmlResultToBoolean(Object)
     * @return see description
     */    
    public static boolean matchesAny(final String anXpath, final Node aNode) {
    	XPath xpath = aNode.createXPath(anXpath);
    	Object xpathResult = xpath.evaluate(aNode);
    	return xmlResultToBoolean(xpathResult);
    }
    
    
    /**
     * returns true if the xpathResult is any of the following: 
     * a boolean with value true,
     * a list with a size > 0,
     * a Node (non null),
     * a String,
     * a Number.
     * Otherwise returns false.
     * Used by {@link #matchesAny(String, Node)} 
     * @param aNode
     * @param anXpath
     * @return see description
     */    
    public static boolean xmlResultToBoolean(Object xpathResult) {
        if(xpathResult == null) {
            return false;
        }
        
        // if it was a query with a boolean expression we will get a Boolean.
        if(xpathResult instanceof Boolean) {
            return ((Boolean) xpathResult).booleanValue();
        }
        
        // if it was a query with multiple results then we will get a List
        if(xpathResult instanceof List) {
            return ((List) xpathResult).size() > 0;
        }
        
        // if it was a query with a single node result then we will get that node
        if(xpathResult instanceof Node) {
            return true;
        }
        
        // if it was a query for the text of a node then we will get a string
        if(xpathResult instanceof String) {
            return true;
        }

        // if it was a query for the count of something or a numeric function
        // then we will get back a number
        if(xpathResult instanceof Number) {
            return true;
        }
        return false;
    }
    
    
    public static Element addOptionalElement (final Element base, final String name, final String value) {
        if ( value == null || "".equals(value) ) {
            return null;
        }
        Element result = base.addElement(name);
        result.setText(value);
        return result;
    }
    
    public static Element addMandatoryElement (final Element base, final String name, final String value) {
        Element result = base.addElement(name);
        if ( value == null || "".equals(value) ) {
            return result;
        }
        result.setText(value);
        return result;
    }

    /**
     * build a whole hierarchy of XML Nodes
     *
     * @param aRootElement
     * @param anElementName   can be a single 'TagName' or 'NameA/NameB/NameC/TagName'
     */
    public static Element addNestedElement (
        final Element aRootElement,
        final String anElementName,
        final String aValue)
    {
        int slashAt = anElementName.indexOf ('/');

        // if the tag name comes without a parent tag, i.e. no '/',
        // we can safely add the Element and re done
        if (-1 == slashAt) {
            // treat attributes specially
            if ('@' == anElementName.charAt (0)) {
                return aRootElement.addAttribute (anElementName.substring (1), aValue);                
            }
            return aRootElement.addElement (anElementName).addText (aValue);                
        }

        // separate parent tag from child tag
        //
        // out of "A/B" we get
        //        elementName      as "A"
        //        childElementName as "B"
        String elementName = anElementName.substring (0, slashAt);
        Element element = aRootElement.element (elementName);

        // only add the element if it does not exist yet
        if (null == element) {
            element = aRootElement.addElement (elementName);
        }

        String childElementName = anElementName.substring (slashAt + 1);

        return addNestedElement (element, childElementName, aValue);
    }

    /**
     * removes the schema attributes noNamespaceSchemaLocation and xsi
     * from the root element of the payload. Then flattens the XML using the UTF-8
     * encoding, see {@link #flattenXML(byte[], String)}
     * 
     * @deprecated this version uses UTF-8
     * @param payload the xml which should have the schema attributes removed
     * @return the modified payload
     * @throws DocumentException if the payload cannot be parsed
     * @throws IOException if the document cannot be written
     */
    @Deprecated
    public static byte[] removeSchemaAttrs(byte[] payload) throws Exception {
        return removeSchemaAttrs(payload, "UTF-8"); 
    }

    /**
     * removes the schema attributes noNamespaceSchemaLocation and schemaLocation 
     * as well as all namespace nodes from the root element of the payload.
     * Then flattens the XML using the given encoding, see {@link #flattenXML(byte[], String)}
     * 
     * @param payload the xml which should have the schema attributes removed
     * @param encoding
     * @return the modified payload
     * @throws DocumentException if the payload cannot be parsed
     * @throws IOException if the document cannot be written
     */
    public static byte[] removeSchemaAttrs (final byte[] payload, final String encoding) throws Exception {
        byte[] response = null;

        Document doc = XmlParser.parse(payload);
        doc = removeSchemaAttrs(doc);
        response = flattenXML(doc, encoding);

        return response;
    }

    /**
     * removes the schema attributes noNamespaceSchemaLocation and schemaLocation 
     * as well as all namespace nodes from the root element of the payload.
     * Then flattens the XML using the given encoding, see {@link #flattenXML(byte[], String)}
     * 
     * @param the document which should have the schema attributes removed
     * @return the modified document
     * @throws DocumentException if the payload cannot be parsed
     * @throws IOException if the document cannot be written
     */
    public static Document removeSchemaAttrs (final Document doc) {
        Element r = doc.getRootElement();
        
        Attribute noNamespaceSchemaLocation = r.attribute( "noNamespaceSchemaLocation" );
        if(noNamespaceSchemaLocation != null) {
            r.remove( noNamespaceSchemaLocation );
        }

        Attribute schemaLocation = r.attribute( "schemaLocation" );
        if(schemaLocation != null) {
            r.remove( schemaLocation );
        }

        Iterator iterator = r.nodeIterator();
        while(iterator.hasNext()) {
            Node aNode = (Node) iterator.next();
            if (aNode.getNodeType() == Node.NAMESPACE_NODE) {
                iterator.remove();
            }
        }
        
        return doc;
    }
    
    /**
     * formats the xml payload into a clarify friendly format with UTF-8 encoding,
     * removing the newline between declaration and root element  
     * @deprecated this version of the method uses UTF-8
     * @param payload the xml which should be "flattened"
     * @return the modified payload
     * @throws UnsupportedEncodingException if UTF-8 encoding is not supported
     * @throws DocumentException if the payload cannot be parsed
     * @throws IOException if the document cannot be written
     */
    @Deprecated
    public static byte[] flattenXML(byte[] payload) throws Exception {
        return flattenXML(payload, "UTF-8");
    }
    
    
    /**
     * formats the xml payload into a clarify friendly format with the given encoding, 
     * removing the newline between declaration and root element  
     * @param payload the xml which should be "flattened"
     * @param encoding the encoding for the result xml
     * @return the modified payload
     * @throws UnsupportedEncodingException if UTF-8 encoding is not supported
     * @throws DocumentException if the payload cannot be parsed
     * @throws IOException if the document cannot be written
     */
    public static byte[] flattenXML(byte[] payload, String encoding) throws Exception {
		Document doc = XmlParser.parse(payload);
        return flattenXML(doc, encoding);
    }

    
    /**
     * formats the document into a clarify friendly format with UTF-8 encoding, 
     * removing the newline between declaration and root element  
     * @deprecated this method uses UTF-8 encoding
     * @param doc the document to be formated
     * @return the document as xml
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    @Deprecated
    public static byte[] flattenXML (final Document doc) throws Exception {
        return flattenXML (doc, "UTF-8");
    }

    /**
     * formats the document into a clarify friendly format with the given encoding, 
     * removing the newline between declaration and root element  
     * @param doc the document to be formated
     * @param encoding the encoding for the result xml
     * @return the document as xml
     * @throws UnsupportedEncodingException
     * @throws IOException
     */
    public static byte[] flattenXML (final Document doc, final String encoding) throws Exception {
        ByteArrayOutputStream bytesout = new ByteArrayOutputStream();

        OutputFormat flattenXmlFormat = new OutputFormat();
        flattenXmlFormat.setEncoding(encoding);
        flattenXmlFormat.setExpandEmptyElements(true);
        flattenXmlFormat.setIndent(false);
        flattenXmlFormat.setNewlines(false);
        flattenXmlFormat.setTrimText(true);
        flattenXmlFormat.setSuppressDeclaration(false);
        flattenXmlFormat.setNewLineAfterDeclaration(false);

        // now write the xml
		XMLWriter writer = new XMLWriter(bytesout, flattenXmlFormat);
		writer.write (doc);

        return bytesout.toByteArray ();
    }
    
    /**
     * Escape XML entities in a String.
     * 
     * @param value unescaped string
     * @return escaped string
     */
	public static String escapeXML (String value)
	{
		int i = 0;
		while ((i = value.indexOf ('&', i + 1)) > -1) {
			value = value.substring (0, i) + "&amp;" + value.substring (i + 1);
		}
		while ((i = value.indexOf ('"')) > -1) {
			value = value.substring (0, i) + "&quot;" + value.substring (i + 1);
		}
		while ((i = value.indexOf ('<')) > -1) {
			value = value.substring (0, i) + "&lt;" + value.substring (i + 1);
		}
		while ((i = value.indexOf ('>')) > -1) {
			value = value.substring (0, i) + "&gt;" + value.substring (i + 1);
		}
		return value;
	}

	/*
     * strip occurences of Namespace declarations
     * these have the format
     *    ' xmlns:[ALPHA]+=["']URI['"] or
     *    ' xmlns=["']URI['"]
     * ALPHA means any strict alpha-character sequence
     * URI is a sequence of alpha-characters, spiked with the usual protocol bits
	 */
    public static String stripNamespaces (final String payload)
    {
        return
            payload.
                replaceAll (" xmlns[^=]+=['\\\"][^'\\\"]+['\\\"]", "").
                replaceAll (" xmlns=['\\\"][^'\\\"]+['\\\"]", "").
                replaceAll ("<([/]?)[^>:]+:([^>]+)>", "<$1$2>");
    }
}
