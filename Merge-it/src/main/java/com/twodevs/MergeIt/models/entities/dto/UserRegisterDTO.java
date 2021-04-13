package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UserRegisterDTO implements Serializable{
	
	private String username;
	private String password;
	private String email;
	private String name;
	private String surname;
	private LocalDate registerDate;
	
	public UserRegisterDTO() {
	}
	

	public UserRegisterDTO(String username, String password, String email, String name, String surname,
			LocalDate registerDate) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.registerDate = registerDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	public LocalDate getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	
	
	

}
