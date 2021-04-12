package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.twodevs.MergeIt.models.entities.Team;


public class TeamDTO implements Serializable{
	
	private int id;
	private String name;	
	private Set<UserDTO> users = new HashSet<UserDTO>(0);
	private Set<ProjectDTO> projects = new HashSet<ProjectDTO>(0);	
	
	public TeamDTO(Team team) {
		this.id = team.getId();
		this.name = team.getName();
	}
	
	public TeamDTO() {
	}

	public TeamDTO(int id, String name, Set<UserDTO> users, Set<ProjectDTO> projects) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.projects = projects;
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

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public Set<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectDTO> projects) {
		this.projects = projects;
	}
	
	
	

}
