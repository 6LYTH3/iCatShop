package com.blythe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserImp implements UserService {
	public static String newline = System.getProperty("line.separator");
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;

	@Override
	public String getUserByName(String name) {
		String buff;
		try {
			fr = new FileReader("users.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] username = buff.split(":");
				if (username[0].equals(name)) {
					return username[2];
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createAccount(String name, String password, String role) {
		try {
			fw = new FileWriter("users.txt", true);
			fw.write(name + ":" + password + ":" + role + newline);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Created");
	}

	@Override
	public boolean authen(String username, String password) {
		String buff;
		try {
			fr = new FileReader("users.txt");
			br = new BufferedReader(fr);
			while ((buff = br.readLine()) != null) {
				String[] user = buff.split(":");
				if (user[0].equals(username) && user[1].equals(password)) {
					return true;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
