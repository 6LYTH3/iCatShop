package com.blythe;

public class Register extends User {

	public Boolean isUser(String name) {
		return getName().equalsIgnoreCase(name);
	}

	public boolean addUser(String name, String password) {
		if (isUser(name))
			return false;

		setName(name);
		return true;
	}

}
