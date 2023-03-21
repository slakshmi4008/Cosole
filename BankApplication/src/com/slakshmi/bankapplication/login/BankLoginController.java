package com.slakshmi.bankapplication.login;

import java.util.UUID;

import com.slakshmi.bankapplication.Transaction.TransactionView;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.NewRegister;
import com.slakshmi.bankapplication.dto.UserCredentials;
import com.slakshmi.bankapplication.library.AbstractController;
import com.slakshmi.bankapplication.login.BankLoginModel.BankLoginModelControlerCallBack;

public class BankLoginController extends AbstractController
		implements BankLoginControllerCallBack, BankLoginModelControlerCallBack {

	private BankLoginViewCallBack loginView;
	private BankLoginModelCallBack loginModel;
	private int currCustomerId = 2000;
	private int currAccountNum = 0;

	public BankLoginController(BankLoginViewCallBack loginView) {
		loginModel = new BankLoginModel(this);
		this.loginView = loginView;
	}

	public void processOption(int option) {
		switch (option) {
		case 1:
			loginView.checkForLogin();

		case 2:

		default: {
			System.out.println("Please enter valid option");
			loginView.create();
		}
		}
	}

	public void checkCredentials(String userName, String password) {
		UserCredentials user = loginModel.checkCredentials(userName, password);
		if (user != null) {
			loginView.successMessage("Yuu have been successfully logged in");
			TransactionView transactionView = new TransactionView();
			transactionView.tranactionIndex(userName);
		} else {
			loginView.errorMessage("Invalid Credentials");
			loginView.create();
		}

	}

	/*
	 * public void createNewAccount(NewRegister newRegister) {
	 * 
	 * Customer customer
	 * =loginModel.createNewAccount(newRegister,generateCustomerId(),
	 * generateAccountNum());
	 * 
	 * if(customer!=null) { showCustomerdetails(customer);
	 * getNewLoginDetails(customer);
	 * 
	 * } else {
	 * message("There is some error in your account creation please try again"); }
	 * 
	 * }
	 */

	/*
	 * private void getNewLoginDetails(Customer customer) {
	 * 
	 * String userName = customer.getCustomerId() + ""; String password =
	 * generateOneTimePassWord(); UserCredentials userCredentials = new
	 * UserCredentials(userName,password);
	 * if(loginModel.getNewLoginDetails(userCredentials))
	 * message("Your login id is " + userCredentials.getUserName()
	 * +"and password is " + userCredentials.getPassword()); loginView
	 * .checkForLogin(); }
	 */

	private void showCustomerdetails(Customer customer) {

		message("Your account is successfully created and your customer id is " + customer.getCustomerId()
				+ " and your account number is " + customer.getAccountNum());

	}

	/*
	 * public void checkForNewRegister(NewRegister newRegister) {
	 * 
	 * if(loginModel.checkForNewRegister(newRegister)) createNewAccount(
	 * newRegister); else {
	 * message("Your email already exist.Please create account with new email"); }
	 * 
	 * }
	 */

	public int generateCustomerId() {
		currCustomerId++;
		return currCustomerId;
	}

	public String generateAccountNum() {
		currAccountNum++;
		return "9100000" + currAccountNum;
	}

	private String generateOneTimePassWord() {
		UUID uuid = UUID.randomUUID();
		String value = uuid.toString().replace("-", "");
		String password = value.substring(value.length() - 8);
		return password;
	}

}
