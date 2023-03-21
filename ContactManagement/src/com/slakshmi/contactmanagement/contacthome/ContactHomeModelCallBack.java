package com.slakshmi.contactmanagement.contacthome;

import java.util.List;

import com.slakshmi.contactmanagement.dto.Contact;

public interface ContactHomeModelCallBack {

	void addContact(Contact contact);

	void removeContact(int contactId);

	List<Contact> showContact();

	void editContact(int contactId, String fieldToBeupdated, String updatedValue);

}
