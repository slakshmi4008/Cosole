package com.slakshmi.bankapplication.Transaction;

import java.util.List;

import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.Transaction;

public interface TransactionViewCallBack {

	void showMyProfile(Customer customer);

	void tranactionIndex(String userName);

	void printAccount(Account account);

	int getDepositDetails();

	void showtransactionHistory(List<Transaction> transaction);

}
