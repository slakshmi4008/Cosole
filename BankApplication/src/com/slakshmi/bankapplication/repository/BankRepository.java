package com.slakshmi.bankapplication.repository;

import java.util.ArrayList;
import java.util.List;

import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.AdminCredentials;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.NewRegister;
import com.slakshmi.bankapplication.dto.Transaction;
import com.slakshmi.bankapplication.dto.UserCredentials;

public class BankRepository {

	private static BankRepository bankDbInstance;
	private List<UserCredentials> userCredentials = new ArrayList<>();
	private List<AdminCredentials> adminCredentials = new ArrayList<>();
	private List<Transaction> transaction = new ArrayList<>();
	private List<Customer> customerDetails = new ArrayList<>();
	private List<Account> accountDetails = new ArrayList<>();
	private int transactionId = 1;

	private BankRepository() {

	}

	public static BankRepository getInstance() {
		if (bankDbInstance == null) {
			bankDbInstance = new BankRepository();
			bankDbInstance.initialSetup();
		}
		return bankDbInstance;
	}

	private void initialSetup() {
		UserCredentials user = new UserCredentials("3001", "3001");
		userCredentials.add(user);
		Customer customer = new Customer("3001", "Lakshmi", "9952838833", "1234 5698 7458");
		customerDetails.add(customer);
		Account account = new Account("3001", "90001", "4569", 5000f);
		accountDetails.add(account);
	}

	/*
	 * public boolean checkForNewRegister(NewRegister newRegister) { for(Customer
	 * customer: customerDetails) {
	 * if(customer.getEmail().equals(newRegister.getEmail())) { return false; } }
	 * return true; }
	 * 
	 * public Customer createNewAccount(NewRegister newRegister, int customerId,
	 * String accountNum) { Customer customer = new
	 * Customer(newRegister,customerId,accountNum);
	 * if(customerDetails.add(customer)) return customer; else return null;
	 * 
	 * }
	 * 
	 * public boolean getNewLoginDetails(UserCredentials user) {
	 * 
	 * return userCredentials.add(user); }
	 */
	public UserCredentials checkCredentials(String userName, String password) {
		for (UserCredentials user : userCredentials) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;

	}

	public Customer getProfileDetails(String username) {

		for (Customer customer : customerDetails) {
			if (username.equals(customer.getCustomerId())) {
				return customer;
			}
		}
		return null;
	}

	public void deposit(String userName, int depositAmount) {
		for (Account account : accountDetails) {
			if (account.getCustomerId().equals(userName)) {
				account.setBalance(account.getBalance() + depositAmount);
				updateTransaction(userName, account, depositAmount);
			}
		}
	}

	private void updateTransaction(String userName, Account account, int depositAmount) {
		transaction.add(
				new Transaction(userName, "" + transactionId++, account.getAccountNumber(), "deposit", depositAmount));

	}

	public Account getAccountBalance(String userName) {
		for (Account account : accountDetails) {
			if (account.getCustomerId().equals(userName)) {
				return account;
			}
		}
		return null;
	}

	public List<Transaction> getTransactionHistory(String userName) {
		List<Transaction> transactionHistory = new ArrayList<>();
		for (Transaction trans : transaction) {
			if (trans.getCustomerID().equals(userName)) {
				transactionHistory.add(trans);
			}
		}
		return transactionHistory;
	}
}
