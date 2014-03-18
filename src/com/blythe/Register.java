package com.blythe;

public class Register extends User {

	public boolean addUser(String name, String password, String role) {
		if (isUser(name))
			return false;

		userService.createAccount(name, password, role);
		return true;
	}

}
