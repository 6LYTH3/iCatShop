package com.blythe;

public interface UserService {
	public String getUserByName(String name);

	public void createAccount(String name, String password, String role);

	public boolean authen(String username, String password);
}
