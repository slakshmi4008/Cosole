package com.slakshmi.coursemanagement.dto;

public class User {
	private String userId;
	private String userName;
	private String userType;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String string) {
		this.userId = string;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String toString() {
		return this.getUserName() + " " + this.getUserType();
	}
}
