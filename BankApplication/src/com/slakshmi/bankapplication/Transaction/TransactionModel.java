package com.slakshmi.bankapplication.Transaction;

import java.util.List;

import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.Transaction;
import com.slakshmi.bankapplication.repository.BankRepository;

public class TransactionModel implements TransactionModelCallBack {

	private TransactionModelControlerCallBack transactionController;

	public TransactionModel(TransactionModelControlerCallBack transactionController) {
		this.transactionController = transactionController;
	}

	public Customer getProfileDetails(String customerId) {

		Customer customer = BankRepository.getInstance().getProfileDetails(customerId);
		return customer;
	}

	public void deposit(String userName, int depositAmount) {

		BankRepository.getInstance().deposit(userName, depositAmount);
	}

	public Account getAccountBalance(String userName) {
		Account account = BankRepository.getInstance().getAccountBalance(userName);
		return account;
	}

	public List<Transaction> getTransactionHistory(String userName) {
		List<Transaction> transaction = BankRepository.getInstance().getTransactionHistory(userName);
		return transaction;
	}

	public interface TransactionModelControlerCallBack {

	}

}
