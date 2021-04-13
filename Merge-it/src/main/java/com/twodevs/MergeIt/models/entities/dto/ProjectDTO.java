package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.entities.Team;


public class ProjectDTO implements Serializable{
	
	private int id;
	private String name;
	private TeamDTO team;
	
	public ProjectDTO() {
	}

	public ProjectDTO(Project project) {
		this.id = project.getId();
		this.name = project.getName();
		this.team = new TeamDTO(project.getTeam());
	}	
	
	public ProjectDTO(int id, String name, TeamDTO team) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
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

	public TeamDTO getTeam() {
		return team;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}
	
	

}
