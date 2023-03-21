package com.slakshmi.contactmanagement.contacthome;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.contactmanagement.dto.Contact;

public class ContactHomeView implements ContactHomeViewCallBack {
	private ContactHomeControllerCallBack contactHomeController;
	Scanner scanner = new Scanner(System.in);

	public ContactHomeView() {
		contactHomeController = new ContactHomeController(this);
	}

	public static void main(String[] args) {
		ContactHomeView contactHomeView = new ContactHomeView();
		contactHomeView.create();

	}

	private void create() {
		index();

	}

	public void index() {
		System.out.println("--------------------------------");
		System.out.println("1)Add contact");
		System.out.println("2)Remove contact");
		System.out.println("3)Show contact");
		System.out.println("4)Edit contact");// getting syntax error in sql
		System.out.println("Enter your option: ");
		int option = scanner.nextInt();
		scanner.nextLine();
		contactHomeController.processOption(option);

	}

	public void print(List<Contact> showContactList) {
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-30s | %n", "contactId", "contactName",
				"contactNumber1", "contactNumber2", "email", "notes");

		for (Contact contact : showContactList) {

			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-30s | %n", contact.getContactId(),
					contact.getContacName(), contact.getContactNumber1(), contact.getContactNumber2(),
					contact.getEmail(), contact.getNotes());
		}
	}

	public Contact addContact() {
		System.out.println("Enter contact name:");
		String contactName = scanner.next();
		System.out.println("Enter contact number1:");
		String contactNumber1 = scanner.next();
		System.out.println("Enter contact number2:");
		String contactNumber2 = scanner.next();
		System.out.println("Enter email:");
		String email = scanner.next();
		scanner.nextLine();
		System.out.println("Enter notes: ");
		String notes = scanner.nextLine();
		Contact contact = new Contact(0, contactName, contactNumber1, contactNumber2, email, notes);
		return contact;
	}

	public int removeContact() {
		System.out.println("Enter contact id to remove:");
		int contactId = scanner.nextInt();
		scanner.nextLine();
		return contactId;
	}

	public int editContact() {
		System.out.println("Enter contact id to edit:");
		int contactId = scanner.nextInt();
		scanner.nextLine();
		return contactId;

	}

	public String geteditContactField() {
		System.out.println("Enter field to edit:");
		// not validated the input -have to change it to Enter option format so that validation is not required
		System.out.println("contactName/contactNumber1/contactNumber2/email/notes");
		String fieldToBeupdated = scanner.next();
		scanner.nextLine();
		return fieldToBeupdated;
	}

	public String getUpdatedValue() {
		System.out.println("Enter updates value:");
		String updatedValue = scanner.nextLine();
		return updatedValue;
	}
}
