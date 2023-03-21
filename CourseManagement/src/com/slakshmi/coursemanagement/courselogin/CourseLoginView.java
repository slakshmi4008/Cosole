package com.slakshmi.coursemanagement.courselogin;

import java.util.Scanner;

public class CourseLoginView implements CourseLoginViewCallBack {

	private CourseLoginControllerCallBack courseLoginUserController;
	Scanner scanner = new Scanner(System.in);

	public CourseLoginView() {
		courseLoginUserController = new CourseLoginController(this);
	}

	public static void main(String[] args) {
		CourseLoginView courseLoginUserView = new CourseLoginView();
		courseLoginUserView.loginIndex();
	}

	public void loginIndex() {
		System.out.println("--------------------------------");
		System.out.println("1)User Login");
		System.out.println("2)Admin Login");
		System.out.println("3)Sign Up");// to be developed
		System.out.println("Enter the option ");
		int option = scanner.nextInt();
		processOption(option);

	}

	private void processOption(int option) {
		switch (option) {
		case 1: {

			getLoginDetails("user");
			break;
		}
		case 2: {

			getLoginDetails("admin");
			break;

		}
		case 3: {
			// to be developed
			break;
		}
		default:{
			System.out.println("Please enter valid option");
			loginIndex();
		}
		}

	}

	private void getLoginDetails(String loginType) {

		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();

		courseLoginUserController.checkCredentials(userName, password, loginType);
	}

	public static void errorMessage(String errorMessage) {
		System.out.println(errorMessage);

	}

}
