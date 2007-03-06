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

import java.io.UnsupportedEncodingException;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.ContentHandler;


/**
 *  A ContentHandler for String payloads. 
 * 
 * In serialized form, the payload is stored in ISO-8859-1 encoding.
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class StringContentHandler implements ContentHandler {

	public static final String CONTENT_TYPE = "text/plain";
	
	public static final String ENCODING_PROPERTY = "string.attachment.encoding";
	public static final String ENCODING_PROPERTY_DEFAULT = "ISO-8859-1";
	
	private String content;
	private Attachment attachment;
	
	public StringContentHandler() {
	}
	
	public StringContentHandler( String content ) {
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
				content = new String(attachment.getContent(), attachment.getProperty(ENCODING_PROPERTY) );
			} catch ( UnsupportedEncodingException uee ) {
				throw new RuntimeException(uee);
			}
		}
	}
	
	protected void store() {
		if ( attachment != null ) {
			try {
				attachment.setContent(content.getBytes(ENCODING_PROPERTY_DEFAULT));
			} catch ( UnsupportedEncodingException uee ) {
				throw new RuntimeException(uee);
			}
			attachment.setContentType( CONTENT_TYPE );
			attachment.addProperty(ENCODING_PROPERTY, ENCODING_PROPERTY_DEFAULT);
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		store();
	}
	
	public Object getContentObject() {
		return getContent();
	}
	
	@Override
    public String toString() {
		if ( this.content != null ) {
			return this.content;
		}
		return "";
	}
}
