package com.slakshmi.bankapplication.login;

public interface BankLoginControllerCallBack {

	void processOption(int option);

	void checkCredentials(String userName, String password);

}
