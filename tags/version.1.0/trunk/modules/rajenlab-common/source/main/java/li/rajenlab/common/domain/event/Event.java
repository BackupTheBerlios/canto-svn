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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import li.rajenlab.common.service.guid.Guid;

/**
 * An Event forms the basis of asynchronous communications between components.
 * Components can be intra module Processes, intra application Modules or even
 * external Applications.
 * 
 * Events consist of any number of Attachments and Properties. Several 
 * standard properties are defined for convenience to define an addressing
 * scheme and communication patterns. 
 * @see li.rajenlab.common.domain.event.StandardEventProperties
 * 
 * An Event can be serialized and unserialized through the EventService.
 * @see li.rajenlab.common.service.event.EventService.
 *
 * @author  neoraph (neoraph@rajen-lab.li)
 * @version $Id$
 */
public final class Event {
	
	/**
	 * Top level event Properties.
	 */
	private Properties properties_;
	
	/**
	 * Named Attachments.
	 */
	private Map<String,Attachment> attachments_ = new HashMap<String,Attachment>();
	
	public Event(){
		this.properties_ = new Properties();
		addProperty( StandardEventProperties.EVENT_ID, new Guid().nextFormatedGUID());
	}
	
	public Event( Properties properties ){
		this.properties_ = properties;
	}

	public Properties getProperties() {
		return properties_;
	}
	
	public void addProperties( Properties properties ) {
		this.properties_.putAll(properties);
	}
	
	public void addProperty( String name, String value ) {
		this.properties_.put(name,value);
	}
	
	public String getProperty( String name ) {
		return (String)this.properties_.get(name);
	}
	
	public void removeProperty( String name ) {
		this.properties_.remove(name);
	}
	
	@SuppressWarnings("unchecked")
    public List getPropertyNames() {
		List propertyNameList = new ArrayList(this.properties_.keySet());
		Collections.sort(propertyNameList);
		return propertyNameList;
	}
	
	@SuppressWarnings("unchecked")
    public void addAttachment( String name, Attachment attachment ){
		this.attachments_.put(name, attachment);
	}
	
	public void removeAttachment( String name ) {
		this.attachments_.remove(name);
	}
	
	public Attachment getAttachment( String name ) {
		return this.attachments_.get(name);
	}
	
	
    public List<String> getAttachmentNames() {
		List<String> attachmentList = new ArrayList<String>( this.attachments_.keySet() );
		Collections.sort(attachmentList);
		return attachmentList;
	}
	
	@Override
    public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Event [\n");
		Iterator iterator = getPropertyNames().iterator();
		while( iterator.hasNext() ) {
			String key = (String)iterator.next();
			s.append( key ).append("=").append(getProperty(key)).append("\n");
		}
		iterator = getAttachmentNames().iterator();
		while( iterator.hasNext() ) {
			String key = (String)iterator.next();
			s.append( "Attachment " ).append(key).append(" [\n");
			s.append( getAttachment(key) );
			s.append( "]\n");
		}
		return s.toString();
	}
}
