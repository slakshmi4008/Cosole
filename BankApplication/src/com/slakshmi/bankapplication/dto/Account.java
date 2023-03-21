package com.slakshmi.bankapplication.dto;

public class Account {
	private String customerId;
	private String accountNumber;
	private final String IFSCCode = "SK000ZS01";
	private String transactionPassword;
	private float balance;

	public Account(String customerId, String accountNumber, String transactionPassword, float balance) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		this.transactionPassword = transactionPassword;
		this.balance = balance;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

}
