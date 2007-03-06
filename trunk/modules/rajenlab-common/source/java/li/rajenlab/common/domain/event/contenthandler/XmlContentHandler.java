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

package li.rajenlab.common.domain.event.contenthandler;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.ContentHandler;
import li.rajenlab.common.service.xml.XmlParser;
import li.rajenlab.common.service.xml.XmlWriter;

import org.dom4j.Document;


/**
 * A ContentHandler for XML payloads. The ContentHandler provides a parsed
 * dom4j Document representation of the XML. In serialized form, the payload
 * is ISO-8859-1 encoded XML byte data.
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class XmlContentHandler implements ContentHandler {

	public static final String CONTENT_TYPE = "text/xml";
	
	public static final String ENCODING_PROPERTY = "xml.attachment.encoding";
	public static final String ENCODING_PROPERTY_DEFAULT = "ISO-8859-1";
	
	private Document content;
	private Attachment attachment;
	
	public XmlContentHandler() {
	}
	
	public XmlContentHandler( Document content ) {
		this.content = content;
	}
	
	public String getContentType() {
		return CONTENT_TYPE;
	}

	public void attach(Attachment attachment) {
		this.attachment = attachment;
		if ( content != null ) {
			store();
		} else {
			load();
		}
	}

	protected void load() {
		if ( attachment != null ) {
			try {
				content = XmlParser.parse(attachment.getContent());
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected void store() {
		if ( attachment != null ) {
			try {
				attachment.setContent(XmlWriter.format(content));
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
			attachment.setContentType( CONTENT_TYPE );
		}
	}

	public Document getContent() {
		return content;
	}

	public void setContent(Document content) {
		this.content = content;
		store();
	}
	
	public Object getContentObject() {
		return getContent();
	}
	
	@Override
    public String toString() {
		if ( this.content != null ) {
			return XmlWriter.formatToString(content);
		}
		return "";
	}
}
