package com.twodevs.MergeIt.models.entities.dto;

import java.util.HashSet;
import java.util.Set;

import com.twodevs.MergeIt.models.entities.Team;

public class TeamUsersDTO {
	
	private int id;
	private String name;
	private Set<UserDTO> users = new HashSet<UserDTO>(0);
	
	public TeamUsersDTO(Team team) {
		this.id = team.getId();
		this.name = team.getName();
		team.getUsers().stream().forEach(u -> users.add(new UserDTO(u)));
	}
	
	public TeamUsersDTO() {
	}
	
	public TeamUsersDTO(int id, String name, Set<UserDTO> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
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
	
	
	
	
}
