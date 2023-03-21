package com.slakshmi.bankapplication.login;

public interface BankLoginViewCallBack {

	void checkForLogin();

	void successMessage(String string);

	void errorMessage(String string);

	void create();

	
}
