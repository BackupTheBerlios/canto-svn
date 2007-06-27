/**
 * 
 */
package pareon.canto.framework.domain.component;

import pareon.canto.framework.domain.DomainEntity;

/**
 * Represent a component of canto
 * @author tzhrora2
 *
 */
public class Component extends DomainEntity {
	
	private String name;
	private String description;
	private boolean enabled;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
