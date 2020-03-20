package com.company.Customer.dto;

public class LoginResponse {
	private final String jwt;

	public LoginResponse(String jwt) {
		//super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
