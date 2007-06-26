/**
 * 
 */
package pareon.canto.framework.domain.security;

import pareon.canto.framework.domain.DomainEntity;

/**
 * Represents a role in canto
 *
 * @author tzhrora2
 *
 */
public class Role extends DomainEntity {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
