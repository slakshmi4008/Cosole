package com.slakshmi.bankapplication.Transaction;

import java.util.List;

import com.slakshmi.bankapplication.Transaction.TransactionModel.TransactionModelControlerCallBack;
import com.slakshmi.bankapplication.dto.Account;
import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.Transaction;

public class TransactionController implements TransactionControllerCallBack, TransactionModelControlerCallBack {

	private TransactionViewCallBack transactionView;
	private TransactionModelCallBack transactionModel;

	public TransactionController(TransactionViewCallBack transactionView) {
		this.transactionView = transactionView;
		transactionModel = new TransactionModel(this);
	}

	public void processTransactionIndex(int option, String userName) {
		switch (option) {
		case 1: {
			Customer customer = transactionModel.getProfileDetails(userName);
			transactionView.showMyProfile(customer);
			transactionView.tranactionIndex(userName);
			break;
		}
		case 2: {
			Account account = transactionModel.getAccountBalance(userName);
			transactionView.printAccount(account);
			transactionView.tranactionIndex(userName);
			break;
		}
		case 3: {
			int depositAmount = transactionView.getDepositDetails();
			transactionModel.deposit(userName, depositAmount);
			transactionView.tranactionIndex(userName);
			break;
		}
		case 4: {
			List<Transaction> transaction = transactionModel.getTransactionHistory(userName);
			transactionView.showtransactionHistory(transaction);
			transactionView.tranactionIndex(userName);
			break;
		}
		}
	}
}
