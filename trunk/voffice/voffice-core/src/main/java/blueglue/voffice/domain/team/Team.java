package blueglue.voffice.domain.team;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import blueglue.voffice.domain.profile.Profile;

public class Team implements Serializable {
	
	private long teamId;
	private String name;
	
	private Set<Profile> peoples;
	private Team parentTeam;
	
	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Profile> getPeoples() {
		return peoples;
	}

	public void setPeoples(Set<Profile> peoples) {
		this.peoples = peoples;
	}
	
	public synchronized void addPeople(Profile people){
		if (peoples == null){
			peoples = new HashSet<Profile>();
		}
		peoples.add(people);
	}
	
	public synchronized void removePeople(Profile people){
		if (peoples !=null){
			peoples.remove(people);
		}
	}

	public Team getParentTeam() {
		return parentTeam;
	}

	public void setParentTeam(Team parentTeam) {
		this.parentTeam = parentTeam;
	}
	
}
