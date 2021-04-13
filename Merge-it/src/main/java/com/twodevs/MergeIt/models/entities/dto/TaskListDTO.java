package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.Project;
import com.twodevs.MergeIt.models.entities.TaskList;

public class TaskListDTO implements Serializable{
	
	private int id;
	private String name;
	@JsonIgnoreProperties("team")
	private ProjectDTO project;
	private LocalDate createdAt;
	private Boolean archived;
	
	public TaskListDTO(TaskList taskList) {
		this.id = taskList.getId();
		this.name = taskList.getName();
		this.createdAt = taskList.getCreatedAt();
		this.archived = taskList.getArchived();
		this.project = new ProjectDTO(taskList.getProject());
	}
	
	public TaskListDTO() {
	}	

	public TaskListDTO(int id, String name, ProjectDTO project, LocalDate createdAt, Boolean archived) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
		this.createdAt = createdAt;
		this.archived = archived;
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}	
	

}
