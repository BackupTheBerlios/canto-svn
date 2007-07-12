package blueglue.voffice.domain.profile;

import org.acegisecurity.GrantedAuthority;

public class Role implements GrantedAuthority {

	private int id;
	private String name;
	
	public String getAuthority() {
		return new StringBuffer("ROLE_").append(getName()).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
