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
	
	private Document content_;
	private Attachment attachment_;
	
	public XmlContentHandler() {
	}
	
	public XmlContentHandler( Document content ) {
		this.content_ = content;
	}
	
	public String getContentType() {
		return CONTENT_TYPE;
	}

	public void attach(Attachment attachment) {
		this.attachment_ = attachment;
		if ( content_ != null ) {
			store();
		} else {
			load();
		}
	}

	protected void load() {
		if ( attachment_ != null ) {
			try {
				content_ = XmlParser.parse(attachment_.getContent());
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
		}
	}
	
	protected void store() {
		if ( attachment_ != null ) {
			try {
				attachment_.setContent(XmlWriter.format(content_));
			} catch ( Exception e ) {
				throw new RuntimeException(e);
			}
			attachment_.setContentType( CONTENT_TYPE );
		}
	}

	public Document getContent() {
		return content_;
	}

	public void setContent(Document content) {
		this.content_ = content;
		store();
	}
	
	public Object getContentObject() {
		return getContent();
	}
	
	@Override
    public String toString() {
		if ( this.content_ != null ) {
			return XmlWriter.formatToString(content_);
		}
		return "";
	}
}
