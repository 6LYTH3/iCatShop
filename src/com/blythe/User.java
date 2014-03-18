package com.blythe;

public class User {

	private String name = "username";
	private String password;
	private String role;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordByName(String name) {
		return "password"; // Fixed me
	}

}
