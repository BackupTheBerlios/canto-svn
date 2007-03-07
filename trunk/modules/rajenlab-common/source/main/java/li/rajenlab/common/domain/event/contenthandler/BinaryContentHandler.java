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


/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public class BinaryContentHandler implements ContentHandler {

	public static final String CONTENT_TYPE = "application/octet-stream";
	
	private byte[] content_;
	private Attachment attachment_;
	
	public BinaryContentHandler() {
	}
	
	public BinaryContentHandler( byte[] content ) {
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
			content_ = attachment_.getContent();
		}
	}
	
	protected void store() {
		if ( attachment_ != null ) {
			attachment_.setContent(content_);
			attachment_.setContentType( CONTENT_TYPE );
		}
	}

	public byte[] getContent() {
		return content_;
	}

	public void setContent(byte[] content) {
		this.content_ = content;
		store();
	}
	
	@Override
    public String toString() {
		if ( this.content_ != null ) {
			return "byte["+content_.length+"]";
		}
		return "";
	}
	
	public Object getContentObject() {
		return getContent();
	}
}
