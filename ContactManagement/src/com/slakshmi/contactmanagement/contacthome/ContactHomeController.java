package com.slakshmi.contactmanagement.contacthome;

import java.util.ArrayList;
import java.util.List;

import com.slakshmi.contactmanagement.dto.Contact;

public class ContactHomeController implements ContactHomeControllerCallBack {
	private ContactHomeViewCallBack contactHomeView;
	private ContactHomeModelCallBack contactHomeModel;

	public ContactHomeController(ContactHomeViewCallBack contactHomeView) {
		this.contactHomeView = contactHomeView;
		contactHomeModel = new ContactHomeModel(this);
	}

	public void processOption(int option) {
		switch (option) {
		case 1: {
			Contact contact = contactHomeView.addContact();
			contactHomeModel.addContact(contact);
			contactHomeView.index();
			break;
		}
		case 2: {
			int contactId = contactHomeView.removeContact();
			contactHomeModel.removeContact(contactId);
			contactHomeView.index();
			break;
		}
		case 3: {
			List<Contact> showContactList = contactHomeModel.showContact();
			contactHomeView.print(showContactList);
			showContactList.clear();
			contactHomeView.index();
			break;
		}
		case 4: {
			int contactId = contactHomeView.editContact();
			String fieldToBeupdated = contactHomeView.geteditContactField();
			String updatedValue = contactHomeView.getUpdatedValue();
			contactHomeModel.editContact(contactId, fieldToBeupdated, updatedValue);
			contactHomeView.index();
			break;
		}
		default: {
			System.out.println("Please enter valid option");
			contactHomeView.index();
		}

		}

	}

}
