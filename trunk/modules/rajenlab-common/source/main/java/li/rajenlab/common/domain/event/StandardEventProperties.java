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

package li.rajenlab.common.domain.event;

/**
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public interface StandardEventProperties {

	public static final String EVENT_ID = "eventId";
	
	public static final String SEND_TO = "sendTo";
	public static final String REPLY_TO = "replyTo";
	
	public static final String SENT_TIMESTAMP = "sentTimestamp";
	public static final String RECEIVED_TIMESTAMP = "receivedTimestamp";
	
	public static final String REQUEST_ATTACHMENT_NAME = "RequestAttachment";
	public static final String RESPONSE_ATTACHMENT_NAME = "ResponseAttachment";
	
}
