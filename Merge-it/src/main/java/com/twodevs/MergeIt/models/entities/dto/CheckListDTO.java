package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.CheckList;


public class CheckListDTO implements Serializable {
	
	private int id;
	private String name;
	@JsonIgnoreProperties("taskList")
	private TaskDTO task;
	private Boolean done;
	
	public CheckListDTO(CheckList checkList) {
		this.id = checkList.getId();
		this.name = checkList.getName();
		this.done = checkList.getDone();
		this.task = new TaskDTO(checkList.getTask());
	}
	
	public CheckListDTO() {
	}	

	public CheckListDTO(int id, String name, TaskDTO task, Boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.done = done;
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

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public TaskDTO getTask() {
		return task;
	}

	public void setTask(TaskDTO task) {
		this.task = task;
	}
	
	
	
	
}
