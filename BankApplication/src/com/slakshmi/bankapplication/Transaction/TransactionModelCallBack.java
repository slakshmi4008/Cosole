package com.slakshmi.bankapplication.Transaction;

import java.util.List;

import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.Transaction;

public interface TransactionModelCallBack {

	Customer getProfileDetails(String userName);

	Account getAccountBalance(String userName);

	void deposit(String userName, int depositAmount);

	List<Transaction> getTransactionHistory(String userName);

}
