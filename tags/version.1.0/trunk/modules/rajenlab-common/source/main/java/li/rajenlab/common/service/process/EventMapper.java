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

import li.rajenlab.common.domain.event.EventListener;


/**
 * An EventMapper needs to analyze an incoming Event and if the Event is
 * relevant for a Process, then determine the oid and name of a state method
 * to call. 
 * 
 * The EventMapper must place this oid and method information as
 * Attachment properties
 * 
 * @see #PROPERTY_OID
 * @see #PROPERTY_METHOD
 * 
 * in an attachment which is "known" to both the EventMapper and the Process.
 * 
 * @see StatefullProcessImpl#attachmentName
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public interface EventMapper extends EventListener {

	public static final String PROPERTY_OID    = "eventmapper.oid";
	public static final String PROPERTY_METHOD = "eventmapper.method";
	
}
