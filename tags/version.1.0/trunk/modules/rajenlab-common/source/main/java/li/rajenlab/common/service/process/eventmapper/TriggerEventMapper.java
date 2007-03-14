/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajen-lab
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process.eventmapper;

import li.rajenlab.common.domain.event.Attachment;
import li.rajenlab.common.domain.event.Event;
import li.rajenlab.common.domain.event.StandardEventProperties;
import li.rajenlab.common.service.process.BaseEventMapper;



/**
 * The TriggerEventMapper maps TriggerEvent data to the standard
 * event properties.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class TriggerEventMapper extends BaseEventMapper {

	public void onEvent(Event event) {
		Attachment requestAttachment = event.getAttachment(StandardEventProperties.REQUEST_ATTACHMENT_NAME);
		if ( requestAttachment == null ) {
			return; // not interrested if it doesnt contain the data i'm looking for.
		}
		// determine the oid and method from the incoming data
		Object requestObject = requestAttachment.getContentHandlerObject();
		if ( !(requestObject instanceof TriggerEvent)) {
			return; // only interrested in TriggerEvents
		}
		TriggerEvent triggerEvent = (TriggerEvent)requestObject;
		
		// use standard properties for oid and method communiction to the Process
		Attachment attachment = new Attachment();
		attachment.addProperty( PROPERTY_OID, triggerEvent.getOid());
		attachment.addProperty( PROPERTY_METHOD, triggerEvent.getMethod());
			
		// add the attachment for onto the Event
		event.addAttachment(getAttachmentName(), attachment);
	}		
}
