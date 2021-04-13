package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.entities.Comment;
import com.twodevs.MergeIt.models.entities.File;
import com.twodevs.MergeIt.models.entities.Task;

public class TaskDTO implements Serializable{
	
	private int id;
	private String name;
	private String description;
	@JsonIgnoreProperties("project")
	private TaskListDTO taskList;
	private LocalDate createdAt;
	private String color;
	private Boolean archived;
	
	public TaskDTO(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.description = task.getDescription();
		this.createdAt = task.getCreatedAt();
		this.color = task.getColor();
		this.archived = task.getArchivada();
		this.taskList = new TaskListDTO(task.getTaskList());
	}
	
	public TaskDTO() {
	}
	
	
	public TaskDTO(int id, String name, String description, TaskListDTO taskList, LocalDate createdAt, String color,
			Boolean archived) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.taskList = taskList;
		this.createdAt = createdAt;
		this.color = color;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}	

	public TaskListDTO getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskListDTO taskList) {
		this.taskList = taskList;
	}
	

}
