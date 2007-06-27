/**
 * 
 */
package pareon.canto.framework.domain.account;

import java.util.Calendar;
import java.util.List;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

import pareon.canto.framework.domain.DomainEntity;
import pareon.canto.framework.domain.security.AccessRight;
import pareon.canto.framework.domain.security.Credentials;
import pareon.canto.framework.support.DateTimeUtils;

/**
 * Represents an account in Canto
 * @author tzhrora2
 *
 */
public class Account extends DomainEntity implements UserDetails {
	
	private Credentials credentials;
	private List<AccessRight> accessRights;
	private AccountState accountState;
	private String accountNr;
	private String email;

	public GrantedAuthority[] getAuthorities() {
		return accessRights.toArray(
				new GrantedAuthority[accessRights.size()]);
	}

	public String getPassword() {
		return credentials.getPassword();
	}

	public String getUsername() {
		return credentials.getUsername();
	}

	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		if (AccountState.ACTIVE.equals(accountState) ||
				AccountState.NEW.equals(accountState)){
			return false;
		}
				
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return !DateTimeUtils.isDateInThePast(credentials.getExpiryDate());
	}

	public boolean isEnabled() {
		return !AccountState.DISABLED.equals(accountState);
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<AccessRight> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}

	public AccountState getAccountState() {
		return accountState;
	}

	public void setAccountState(AccountState accountState) {
		this.accountState = accountState;
	}

	public String getAccountNr() {
		return accountNr;
	}

	public void setAccountNr(String accountNr) {
		this.accountNr = accountNr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}
