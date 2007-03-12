/****************************************************************************** 
 * $LastChangedBy$
 * $LastChangedRevision$
 * $LastChangedDate$
 ******************************************************************************
 * Project: rajenlab-common
 ******************************************************************************
 * $HeadURL$
 ******************************************************************************/

package li.rajenlab.common.service.process.eventmapper;

import java.util.Properties;

/**
 * A TriggerEvent has all the information in it as to which process
 * method to trigger and the Process oid. It is used as a method to
 * directly call Process methods.
 * 
 * @author  raph (raph@rajenlab.li)
 * @version $Id$
 */
public class TriggerEvent {

	private String oid_;
	private String method_;
	private Properties properties_ = new Properties();
	
	public TriggerEvent( String oid, String method ) {
		this.oid_ = oid;
		this.method_ = method;
	}
	
	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method_;
	}
	/**
	 * @return Returns the oid.
	 */
	public String getOid() {
		return oid_;
	}

	/**
	 * @return Returns the properties.
	 */
	public Properties getProperties() {
		return properties_;
	}

	/**
	 * @param properties The properties to set.
	 */
	public void setProperties(Properties properties) {
		this.properties_ = properties;
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
	
}
