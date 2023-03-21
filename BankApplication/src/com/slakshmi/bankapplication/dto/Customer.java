package com.slakshmi.bankapplication.dto;

public class Customer {

	private String customerId;
	private String accountNum;
	private String customerName;
	private String mobileNumber;
	private String adharNumber;

	public Customer(String customerId, String customerName, String mobileNumber, String adharNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.adharNumber = adharNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	/*
	 * public Customer(NewRegister newRegister,int customerId,String accountNum ) {
	 * super();
	 * 
	 * this.customerId=customerId; this.accountNum=accountNum; this.firstName =
	 * newRegister.getFirstName(); this.lastName = newRegister.getLastName();
	 * this.email = newRegister.getEmail(); this.mobileNumber =
	 * newRegister.getMobileNumber(); this.adharNumber =
	 * newRegister.getAdharNumber(); }
	 */

}
