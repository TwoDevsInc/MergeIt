package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class ProjectDTO implements Serializable{
	
	private int id;
	private String name;
	private Set<TaskListDTO> taskLists = new HashSet<TaskListDTO>(0);
	
	public ProjectDTO() {
	}

	public ProjectDTO(int id, String name, Set<TaskListDTO> taskLists) {
		super();
		this.id = id;
		this.name = name;
		this.taskLists = taskLists;
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
	public Set<TaskListDTO> getTaskLists() {
		return taskLists;
	}
	public void setTaskLists(Set<TaskListDTO> taskLists) {
		this.taskLists = taskLists;
	}
	
	

}
