/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process;

/**
 * Convenience base class for EventMapper.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public abstract class BaseEventMapper implements EventMapper {

	private String attachmentName_;
	
	public String getAttachmentName() {
		return attachmentName_;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName_ = attachmentName;
	}

}
