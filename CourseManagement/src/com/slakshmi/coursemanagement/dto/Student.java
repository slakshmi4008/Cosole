package com.slakshmi.coursemanagement.dto;

import java.time.LocalDate;

public class Student {

	private String studentID;
	private String userName;
	private String name;
	private String dob;
	private String mobileNum;
	private String courseID;

	public Student(String studentID, String userName, String name, String dob, String mobileNum, String courseID) {
		super();
		this.userName = userName;
		this.name = name;
		this.dob = dob;
		this.mobileNum = mobileNum;
		this.courseID = courseID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dOB) {
		dob = dOB;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

}
