/**
 * 
 */
package pareon.canto.framework.domain.security;

import org.acegisecurity.GrantedAuthority;

import pareon.canto.framework.domain.DomainEntity;
import pareon.canto.framework.domain.component.Component;

/**
 * Represents access rights
 * @author tzhrora2
 *
 */
public class AccessRight extends DomainEntity implements GrantedAuthority{
	
	private Component component;
	private Role role;
	
	
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * @see org.acegisecurity.GrantedAuthority#getAuthority()
	 * 
	 * The Authority name is build as follow:
	 * 
	 * AR_<component>_<role>
	 * 
	 */
	public String getAuthority() {
		return new StringBuffer("AR_").
			append(getComponent().getName()).
			append("_").append(getRole()).toString();
	}

}
