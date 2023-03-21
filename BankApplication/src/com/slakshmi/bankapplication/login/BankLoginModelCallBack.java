package com.slakshmi.bankapplication.login;

import com.slakshmi.bankapplication.dto.UserCredentials;

public interface BankLoginModelCallBack {

	UserCredentials checkCredentials(String userName, String password);

}
