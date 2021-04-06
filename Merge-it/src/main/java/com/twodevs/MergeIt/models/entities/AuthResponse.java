package com.twodevs.MergeIt.models.entities;

public class AuthResponse {
	
	private final String jwt;	

	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}	
	
}
