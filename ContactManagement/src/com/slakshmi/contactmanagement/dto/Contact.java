package com.slakshmi.contactmanagement.dto;

public class Contact {
	private int contactId;
	private String contactName;
	private String contactNumber1;
	private String contactNumber2;
	private String email;
	private String notes;

	public Contact(int contactId, String contactName) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
	}

	public Contact(int contactId, String contactName, String contactNumber1, String contactNumber2, String email,
			String notes) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNumber1 = contactNumber1;
		this.contactNumber2 = contactNumber2;
		this.email = email;
		this.notes = notes;
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContacName() {
		return contactName;
	}

	public void setContacName(String contacName) {
		this.contactName = contacName;
	}

	public String getContactNumber1() {
		return contactNumber1;
	}

	public void setContactNumber1(String contactNumber1) {
		this.contactNumber1 = contactNumber1;
	}

	public String getContactNumber2() {
		return contactNumber2;
	}

	public void setContactNumber2(String contactNumber2) {
		this.contactNumber2 = contactNumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
