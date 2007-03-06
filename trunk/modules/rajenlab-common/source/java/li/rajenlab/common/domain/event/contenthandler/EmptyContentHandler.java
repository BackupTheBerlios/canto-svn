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
public class EmptyContentHandler implements ContentHandler {

	public static final String CONTENT_TYPE = "application/empty";
	
	private byte[] content;
	private Attachment attachment;
	
	public EmptyContentHandler() {
		this.content = new byte[0];
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

	public Object getContentObject() {
		return getContent();
	}
	
	public void setContent(byte[] content) {
		this.content = content;
		store();
	}
	
	@Override
    public String toString() {
		return "empty";
	}
}
