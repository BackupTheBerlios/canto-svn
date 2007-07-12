package blueglue.voffice.domain.profile;

import java.io.Serializable;
import java.util.Date;

public class ProfileActivation implements Serializable {
	
	
	private Date activationDate;
	private String activationCode;
	private Date activationExpiryDate;
	
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public Date getActivationExpiryDate() {
		return activationExpiryDate;
	}
	public void setActivationExpiryDate(Date activationExpiryDate) {
		this.activationExpiryDate = activationExpiryDate;
	}
	
	

}
