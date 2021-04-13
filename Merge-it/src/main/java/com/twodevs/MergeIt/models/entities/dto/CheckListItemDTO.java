package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.CheckListItem;

public class CheckListItemDTO implements Serializable {
	
	private int id;
	private String name;
	@JsonIgnoreProperties("taskList")
	private CheckListDTO checkList;
	private Boolean done;
	
	public CheckListItemDTO(CheckListItem checkListItem) {
		this.id = checkListItem.getId();
		this.name = checkListItem.getName();
		this.done = checkListItem.getDone();	
		this.checkList = new CheckListDTO(checkListItem.getChecklist());
	}
	
	public CheckListItemDTO() {
	}	

	public CheckListItemDTO(int id, String name, CheckListDTO checkList, Boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.checkList = checkList;
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

	public CheckListDTO getCheckList() {
		return checkList;
	}

	public void setCheckList(CheckListDTO checkList) {
		this.checkList = checkList;
	}
	
	
	
}
