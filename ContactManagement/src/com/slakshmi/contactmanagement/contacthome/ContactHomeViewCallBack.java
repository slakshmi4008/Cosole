package com.slakshmi.contactmanagement.contacthome;

import java.util.List;

import com.slakshmi.contactmanagement.dto.Contact;

public interface ContactHomeViewCallBack {

	Contact addContact();

	void index();

	int removeContact();

	int editContact();

	String geteditContactField();

	String getUpdatedValue();

	void print(List<Contact> showContactList);

}
