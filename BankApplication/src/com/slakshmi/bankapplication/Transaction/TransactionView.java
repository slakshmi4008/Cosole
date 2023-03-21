package com.slakshmi.bankapplication.Transaction;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.Transaction;

public class TransactionView implements TransactionViewCallBack {

	private TransactionControllerCallBack tranactionController;
	Scanner scanner = new Scanner(System.in);

	public TransactionView() {
		tranactionController = new TransactionController(this);
	}

	/*
	 * public static void main(String[] args) { TransactionView transactionView =
	 * new TransactionView(); transactionView.tranactionIndex(); }
	 */

	public void tranactionIndex(String userName) {
		System.out.println("--------------------------------------");
		System.out.println("1)My profile");
		System.out.println("2)Show account balance");
		System.out.println("3)Deposit");
		System.out.println("Enter the option");
		int option = scanner.nextInt();
		tranactionController.processTransactionIndex(option, userName);
	}

	public void showMyProfile(Customer customer) {
		System.out.println("--------------------------------------");
		System.out.println("My profile----->");
		System.out.println("Name: " + customer.getCustomerName());
		System.out.println("Number: " + customer.getMobileNumber());
		System.out.println("AdharNumber:  " + customer.getAdharNumber());
	}

	public int getDepositDetails() {
		System.out.println("Enter the amount to be deposited");
		int depositAmount = scanner.nextInt();
		return depositAmount;
	}

	public void printAccount(Account account) {
		System.out.println("--------------------------------");

		System.out.printf("| %-15s | %-15s |  %n", "accountNumber", "Account balance");
		System.out.printf("| %-15s | %-15s |  %n", account.getAccountNumber(), account.getBalance());

	}

	public void showtransactionHistory(List<Transaction> transaction) {
		System.out.println("--------------------------------");

		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %n", "accountNumber", "Transaction Type",
				"Transaction amount");

		for (Transaction trans : transaction) {
			System.out.printf("| %-15s | %-15s | %-15s | %n", trans.getAccountNumber(), trans.getTransactionType(),
					trans.getTransactionAmount());
		}

	}

}
