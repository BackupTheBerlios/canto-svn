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
	
	private byte[] content;
	private Attachment attachment;
	
	public BinaryContentHandler() {
	}
	
	public BinaryContentHandler( byte[] content ) {
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
			content = attachment.getContent();
		}
	}
	
	protected void store() {
		if ( attachment != null ) {
			attachment.setContent(content);
			attachment.setContentType( CONTENT_TYPE );
		}
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
		store();
	}
	
	@Override
    public String toString() {
		if ( this.content != null ) {
			return "byte["+content.length+"]";
		}
		return "";
	}
	
	public Object getContentObject() {
		return getContent();
	}
}
