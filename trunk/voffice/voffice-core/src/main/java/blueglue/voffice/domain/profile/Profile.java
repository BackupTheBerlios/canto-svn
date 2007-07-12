package blueglue.voffice.domain.profile;

import java.util.Date;
import java.util.Set;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;

import blueglue.voffice.support.DateTimeSupport;

public class Profile implements UserDetails {
	
	private String profileId;
	private String password;
	private String username;
	private boolean locked;
	private Date credentialsExpiryDate;
	private Date accountExpiryDate;
	private boolean enabled;
	private ProfileActivation activation;
	private Set<Role> roles;

	public GrantedAuthority[] getAuthorities() {
		return roles.toArray(new GrantedAuthority[roles.size()]);
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return !DateTimeSupport.isDateExpired(accountExpiryDate);
	}

	public boolean isAccountNonLocked() {
		return !locked;
	}

	public boolean isCredentialsNonExpired() {
		return !DateTimeSupport.isDateExpired(credentialsExpiryDate);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getCredentialsExpiryDate() {
		return credentialsExpiryDate;
	}

	public void setCredentialsExpiryDate(Date credentialsExpiryDate) {
		this.credentialsExpiryDate = credentialsExpiryDate;
	}

	public Date getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate(Date accountExpiryDate) {
		this.accountExpiryDate = accountExpiryDate;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public ProfileActivation getActivation() {
		return activation;
	}

	public void setActivation(ProfileActivation activation) {
		this.activation = activation;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	

}
