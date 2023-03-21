package com.slakshmi.contactmanagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.slakshmi.contactmanagement.dto.Contact;

public class ContactRepositoryDb {
	private static ContactRepositoryDb contactRepositoryDb;
	private Statement stmt;
	private Connection con;
	private List<Contact> showContactList = new ArrayList<>();

	private ContactRepositoryDb() {
		stmt = null;
		con = null;
	}

	public static ContactRepositoryDb getInstance() throws Exception {
		if (contactRepositoryDb == null) {
			contactRepositoryDb = new ContactRepositoryDb();
			contactRepositoryDb.executeConnection();
		}
		return contactRepositoryDb;
	}

	private void executeConnection() throws Exception {

		String url = "jdbc:mysql://localhost:3306/myshop";
		String username = "root";
		String password = "Sreeji@4";
		con = DriverManager.getConnection(url, username, password);
		stmt = con.createStatement();
	}

	public List<Contact> showContact() {

		try {

			ResultSet resultSet = stmt.executeQuery("select * from contacts");
			while (resultSet.next()) {

				Contact contact = new Contact(resultSet.getInt("contactId"), resultSet.getString("contactName"),
						resultSet.getString("phone1"), resultSet.getString("phone1"), resultSet.getString("email"),
						resultSet.getString("notes"));
				showContactList.add(contact);

			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return showContactList;

	}

	public void addContact(Contact contact) {
		try {
			stmt.executeUpdate("insert into contacts (contactName,email,phone1,phone2,notes) values('"
					+ contact.getContacName() + "','" + contact.getContactNumber1() + "','"
					+ contact.getContactNumber2() + "','" + contact.getEmail() + "','" + contact.getNotes() + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void removeContact(int contactId) {
		try {
			stmt.executeUpdate("delete from contacts where contactId='" + contactId + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editContact(int contactId, String fieldToBeupdated, String updatedValue) {
		try {
			stmt.executeUpdate("update contacts set "+ fieldToBeupdated +" = '" + updatedValue + "' where contactId='" + contactId + "'");
			//'"+ fieldToBeupdated +"'
			/*String query = "update contacts set '?'= ? where contactId=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, fieldToBeupdated);
			preparedStmt.setString(2, updatedValue);
			preparedStmt.setInt(3, contactId);
			preparedStmt.execute();*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
