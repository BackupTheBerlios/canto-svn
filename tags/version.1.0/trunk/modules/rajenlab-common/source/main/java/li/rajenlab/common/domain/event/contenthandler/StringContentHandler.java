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
	
	private String content_;
	private Attachment attachment_;
	
	public StringContentHandler() {
	}
	
	public StringContentHandler( String content ) {
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
				content_ = new String(attachment_.getContent(), attachment_.getProperty(ENCODING_PROPERTY) );
			} catch ( UnsupportedEncodingException uee ) {
				throw new RuntimeException(uee);
			}
		}
	}
	
	protected void store() {
		if ( attachment_ != null ) {
			try {
				attachment_.setContent(content_.getBytes(ENCODING_PROPERTY_DEFAULT));
			} catch ( UnsupportedEncodingException uee ) {
				throw new RuntimeException(uee);
			}
			attachment_.setContentType( CONTENT_TYPE );
			attachment_.addProperty(ENCODING_PROPERTY, ENCODING_PROPERTY_DEFAULT);
		}
	}

	public String getContent() {
		return content_;
	}

	public void setContent(String content) {
		this.content_ = content;
		store();
	}
	
	public Object getContentObject() {
		return getContent();
	}
	
	@Override
    public String toString() {
		if ( this.content_ != null ) {
			return this.content_;
		}
		return "";
	}
}
