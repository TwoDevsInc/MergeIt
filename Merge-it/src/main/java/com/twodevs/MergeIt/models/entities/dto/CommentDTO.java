package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.twodevs.MergeIt.models.entities.Comment;


public class CommentDTO implements Serializable  {
	
	private int id;
	private UserDTO user;
	private String text;
	private LocalDate createdAt;
		
	public CommentDTO(Comment comment) {
		this.id = comment.getId();
		this.user = new UserDTO(comment.getUser());
		this.text = comment.getText();
		this.createdAt = comment.getCreatedAt();
	}
	
	public CommentDTO() {
	}

	public CommentDTO(int id, UserDTO user, String text, LocalDate createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
