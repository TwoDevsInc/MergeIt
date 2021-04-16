package com.twodevs.MergeIt.models.entities;

import com.twodevs.MergeIt.models.entities.dto.UserDTO;

public class AuthResponse {
	
	private final String jwt;	
	private UserDTO userLogged;

	public AuthResponse(String jwt, UserDTO userLogged) {
		this.jwt = jwt;
		this.userLogged = userLogged;
	}

	public String getJwt() {
		return jwt;
	}

	public UserDTO getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(UserDTO userLogged) {
		this.userLogged = userLogged;
	}	
	
	
}
