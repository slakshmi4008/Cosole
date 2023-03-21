package com.slakshmi.bankapplication.library;

import java.util.Scanner;

import com.slakshmi.bankapplication.login.BankLoginView;

public abstract class AbstractView {

	protected Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		BankLoginView bankLoginView = new BankLoginView();
		bankLoginView.create();

	}

	public int bankLoginIndex() {
		System.out.println("--------------------------------------");
		System.out.println("Welcome to XYX banking system");
		System.out.println("1)User Login");
		System.out.println("2)New User");
		System.out.println("3)Employee Login");
		System.out.println("--------------------------------------");
		System.out.print("Enter an option to proceed");
		int option = scanner.nextInt();
		scanner.nextLine();
		return option;
	}

	public void errorMessage(String errorMessage) {
		System.out.println(errorMessage);

	}

	public void successMessage(String successMessage) {
		System.out.println(successMessage);

	}
}
