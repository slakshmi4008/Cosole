package com.slakshmi.bankapplication.login;

import com.slakshmi.bankapplication.dto.Customer;
import com.slakshmi.bankapplication.dto.NewRegister;
import com.slakshmi.bankapplication.dto.UserCredentials;
import com.slakshmi.bankapplication.repository.BankRepository;

public class BankLoginModel implements BankLoginModelCallBack {

	private BankLoginModelControlerCallBack loginController;

	public BankLoginModel(BankLoginModelControlerCallBack loginController) {
		this.loginController = loginController;
	}

	public UserCredentials checkCredentials(String userName, String password) {
		UserCredentials user = BankRepository.getInstance().checkCredentials(userName, password);
		return user;
	}

	/*
	 * public boolean checkForNewRegister(NewRegister newRegister) { //boolean
	 * isCustomerAlreadyExist
	 * =BankRepository.getInstance().checkForNewRegister(newRegister); //return
	 * isCustomerAlreadyExist; }
	 * 
	 * public Customer createNewAccount(NewRegister newRegister, int customerId,
	 * String accountNum) { /*Customer customer
	 * =BankRepository.getInstance().createNewAccount(newRegister,customerId,
	 * accountNum); if(customer!=null) return customer; else return null; }
	 * 
	 * public boolean getNewLoginDetails(UserCredentials userCredentials) {
	 * 
	 * return BankRepository.getInstance().getNewLoginDetails(userCredentials); }
	 */
	public interface BankLoginModelControlerCallBack {

		
	}

}
