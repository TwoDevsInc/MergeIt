package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twodevs.MergeIt.models.entities.CheckList;
import com.twodevs.MergeIt.models.entities.Comment;
import com.twodevs.MergeIt.models.entities.File;
import com.twodevs.MergeIt.models.entities.Task;

public class TaskDTO implements Serializable{
	
	private int id;
	private String name;
	private String description;
	private LocalDate createdAt;
	private String color;
	private Boolean archived;
	private Set<FileDTO> files = new HashSet<FileDTO>(0);
	private Set<CommentDTO> comments = new HashSet<CommentDTO>(0);
	private Set<CheckListDTO> checkLists = new HashSet<CheckListDTO>(0);
	
	public TaskDTO(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.description = task.getDescription();
		this.createdAt = task.getCreatedAt();
		this.color = task.getColor();
		this.archived = task.getArchivada();
	}
	
	public TaskDTO() {
	}

	public TaskDTO(int id, String name, String description, LocalDate createdAt, String color, Boolean archived,
			Set<FileDTO> files, Set<CommentDTO> comments, Set<CheckListDTO> checkLists) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.color = color;
		this.archived = archived;
		this.files = files;
		this.comments = comments;
		this.checkLists = checkLists;
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

	public Set<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(Set<FileDTO> files) {
		this.files = files;
	}

	public Set<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}

	public Set<CheckListDTO> getCheckLists() {
		return checkLists;
	}

	public void setCheckLists(Set<CheckListDTO> checkLists) {
		this.checkLists = checkLists;
	}
	
	
	
	
	

}
