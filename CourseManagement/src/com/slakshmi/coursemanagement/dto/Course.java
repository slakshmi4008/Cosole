package com.slakshmi.coursemanagement.dto;

public class Course {

	private String courseID;
	private String courseName;
	private String duration;
	private float fee;
	private String startDate;
	private String endDate;

	public Course(String courseID, String courseName, String duration, float fee, String startDate, String endDate) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String toString() {
		return String.format("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |", this.getCourseID(),
				this.getCourseName(), this.getDuration(), this.getFee(), this.getStartDate(), this.getEndDate());
	}
}
