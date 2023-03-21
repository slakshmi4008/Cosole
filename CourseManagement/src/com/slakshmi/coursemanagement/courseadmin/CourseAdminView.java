package com.slakshmi.coursemanagement.courseadmin;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.coursemanagement.dto.Course;
import com.slakshmi.coursemanagement.dto.User;

public class CourseAdminView implements CourseAdminViewCallBack {
	private CourseAdminControllerCallBack courseAdminController;
	Scanner scanner = new Scanner(System.in);
	private User user;

	public CourseAdminView(User user) {
		courseAdminController = new CourseAdminController(this);
		this.user = user;
	}

	public void start() {
		courseIndex();
	}

	public void courseIndex() {
		System.out.println("--------------------------------");
		System.out.println("Welcome to our page " + user.getUserName());
		System.out.println("1)View Course Details");
		System.out.println("2)Add Course Details");
		System.out.println("3)Login page");
		System.out.println("--------------------------------");
		System.out.println("Enter your option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		courseAdminController.processOption(option, user);
	}

	public void print(List<Course> courseDetails) {

		System.out.println("--------------------------------");

		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n", "Course Id", "Course Name",
				"Duration", "Fee", "Start Date", "End Date");

		for (Course course : courseDetails)
			System.out.println(course);

	}

	public void errorMessage(String errorMessage) {

		System.out.println(errorMessage);
	}

	public void successMessage(String successMessage) {

		System.out.println(successMessage);
	}

	public Course addCourse() {
		System.out.println("--------------------------------");
		System.out.println("Enter course Id");
		String courseID = scanner.nextLine();
		System.out.println("Enter course name");
		String courseName = scanner.nextLine();
		System.out.println("Enter course duration");
		String duration = scanner.nextLine();
		System.out.println("Enter fee amount");
		float fee = scanner.nextFloat();
		scanner.nextLine();
		System.out.println("Enter course start date");
		String startDate = scanner.nextLine();
		System.out.println("Enter course end date");
		String endDate = scanner.nextLine();

		Course course = new Course(courseID, courseName, duration, fee, startDate, endDate);
		return course;
	}

}
