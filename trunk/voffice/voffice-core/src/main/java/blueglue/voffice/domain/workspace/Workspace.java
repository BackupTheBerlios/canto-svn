package blueglue.voffice.domain.workspace;

import java.io.Serializable;

import blueglue.voffice.domain.profile.Profile;
import blueglue.voffice.domain.team.Team;

public class Workspace implements Serializable {
	
	
	private String workspaceId;
	private String name;
	
	// Workspace is either a team workspace or a personal workspace of an user
	private Team team;  
	private Profile profile;
	
	private Profile createdBy;

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Profile getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Profile createdBy) {
		this.createdBy = createdBy;
	}
	
	public boolean isTeamWorkspace(){
		return ((team!=null) && (profile==null));
	}
	
	public boolean isProfileWorkspace(){
		return ((team==null) && (profile!=null));
	}
	
}
