package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.twodevs.MergeIt.models.entities.CheckList;


public class CheckListDTO implements Serializable {
	
	private int id;
	private String name;
	private Boolean done;
	private Set<CheckListItemDTO> checkListItems = new HashSet<CheckListItemDTO>(0);
	
	public CheckListDTO(CheckList checkList) {
		this.id = checkList.getId();
		this.name = checkList.getName();
		this.done = checkList.getDone();
	}
	
	public CheckListDTO() {
	}

	public CheckListDTO(int id, String name, Boolean done, Set<CheckListItemDTO> checkListItems) {
		super();
		this.id = id;
		this.name = name;
		this.done = done;
		this.checkListItems = checkListItems;
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

	public Set<CheckListItemDTO> getCheckListItems() {
		return checkListItems;
	}

	public void setCheckListItems(Set<CheckListItemDTO> checkListItems) {
		this.checkListItems = checkListItems;
	}
	
	
	
	
}
