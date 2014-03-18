package com.blythe;

public class Authentication extends User {

	public boolean validate(String username, String password) {
		return userService.authen(username, password);
	}

	public String getPermisstion(String name){
		return userService.getUserByName(name);
	}
}
