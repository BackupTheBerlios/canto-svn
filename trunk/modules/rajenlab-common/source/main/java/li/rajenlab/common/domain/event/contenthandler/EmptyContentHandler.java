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
	
	private byte[] content_;
	private Attachment attachment_;
	
	public EmptyContentHandler() {
		this.content_ = new byte[0];
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

	public Object getContentObject() {
		return getContent();
	}
	
	public void setContent(byte[] content) {
		this.content_ = content;
		store();
	}
	
	@Override
    public String toString() {
		return "empty";
	}
}
