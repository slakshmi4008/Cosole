package com.slakshmi.coursemanagement.courseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.Student;
import com.slakshmi.coursemanagement.dto.User;
import com.slakshmi.coursemanagement.dto.UserCredentials;

public class CourseUserView implements CourseUserViewCallBack {

	private CourseUserControllerCallBack courseController;
	private User user;

	Scanner scanner = new Scanner(System.in);

	public CourseUserView(User user) {
		courseController = new CourseUserController(this);
		this.user = user;
	}

	/*
	 * public static void main(String[] args) { CourseView courseView =new
	 * CourseView(); courseView.start(); }
	 */

	public void start() {
		courseIndex();
	}

	public void courseIndex() {
		System.out.println("--------------------------------");
		System.out.println("Welcome to our page " + user.getUserName());
		System.out.println("1)Course Details");
		System.out.println("2)My Enrollment");
		System.out.println("3)New Enrolment");
		System.out.println("4)Login page");
		System.out.println("Enter your option: ");
		int option = scanner.nextInt();
		courseController.processOption(option, user);
	}

	public void errorMessage(String errorMessage) {

		System.out.println(errorMessage);
	}

	public void successMessage(String successMessage) {

		System.out.println(successMessage);
	}

	public void print(List<Course> courseDetails) {

		System.out.println("--------------------------------");

		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", "Course Id", "Course Name",
				"Duration", "Fee", "Start Date", "End Date");

		for (Course course : courseDetails)
			System.out.println(course);

	}

	public String getCourseID() {
		System.out.println("--------------------------------");
		System.out.println("Enter the course Id ");
		String courseId = scanner.next();
		return courseId;
	}

	public Student getStudentDetails(String courseId) {

		System.out.println("Enter your name ");
		String name = scanner.nextLine();
		scanner.next();
		System.out.println("Enter your date of birth  ");
		String dob = scanner.next();
		System.out.println("Enter your mobile number ");
		String mobile = scanner.next();
		return new Student(null, user.getUserName(), name, dob, mobile, courseId);

	}
}
