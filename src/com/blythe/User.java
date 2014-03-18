package com.blythe;

public class User {

	private String name;
	private String password;
	private String role;
	protected UserService userService = new UserImp();

	public User() {
		// Default Constructor
	}

	public User(String name, String password, String role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

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

	public Boolean isUser(String name) {
		return userService.getUserByName(name) != null;
	}
}
