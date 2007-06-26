/**
 * 
 */
package pareon.canto.framework.domain.security;

import java.io.Serializable;
import java.util.Date;

import pareon.canto.framework.domain.DomainEntity;

/**
 * Credientials in canto
 * @author tzhrora2
 *
 */
public class Credentials extends DomainEntity implements Serializable {
	
	private String username;
	private String password;
	private Date expiryDate;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	

}
