package com.slakshmi.coursemanagement.dto;

public class UserCredentials extends User {
	public UserCredentials(String string, String userName, String userType, String password) {
		super.setUserId(string);
		super.setUserName(userName);
		super.setUserType(userType);
		this.password = password;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return this.getUserName() + " " + this.getUserType();
	}
}
