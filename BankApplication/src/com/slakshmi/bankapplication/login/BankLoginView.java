package com.slakshmi.bankapplication.login;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.slakshmi.bankapplication.Transaction.TransactionView;
import com.slakshmi.bankapplication.dto.NewRegister;
import com.slakshmi.bankapplication.library.AbstractView;

public class BankLoginView extends AbstractView implements BankLoginViewCallBack {

	private BankLoginControllerCallBack loginController;
	private Map<String, String> validateMatches = new HashMap<>();

	public BankLoginView() {
		loginController = new BankLoginController(this);
	}

	public void create() {
		int option = bankLoginIndex();
		// BankLoginView bankLoginView = new BankLoginView();
		// bankLoginView.initialSetup();
		loginController.processOption(option);

	}

	/*
	 * public void initialSetup() { validateMatches.put("firstName","[A-Za-z]*");
	 * validateMatches.put("lastName","[A-Za-z]*");
	 * validateMatches.put("email","^(.+)@(.+)$");
	 * validateMatches.put("mobileNumber","^\\\\d{10}$");
	 * validateMatches.put("adharNumber",
	 * "^[2-9]{1}[0-9]{3}\\\\s[0-9]{4}\\\\s[0-9]{4}$");
	 * //validateMatches.put("addressLine1","[a-z]*");
	 * //validateMatches.put("addressLine2","[a-z]*");
	 * //validateMatches.put("city","[A-Za-z]*");
	 * //validateMatches.put("state","[A-Za-z]*");
	 * //validateMatches.put("country","[A-Za-z]*");
	 * //validateMatches.put("pincode","^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");
	 * //for(Map.Entry<String,String> e : validateMatches.entrySet()) { //
	 * System.out.println(e); //} }
	 */

	/*
	 * private void getRegisterDetails() {
	 * System.out.println("--------------------------------------"); // validating
	 * the input from the user System.out.println("Enter your first name"); String
	 * firstName = scanner.next();
	 * validateRegisterDetails(firstName,validateMatches.get("firstName"),
	 * "firstName"); System.out.println("Enter your last name"); String lastName =
	 * scanner.next();
	 * validateRegisterDetails(lastName,validateMatches.get("lastName"),"lastName");
	 * System.out.println("Enter your email id"); String email = scanner.next();
	 * validateRegisterDetails(email,validateMatches.get("email"),"email");
	 * System.out.println("Enter your mobileNumber"); String mobileNumber =
	 * scanner.next();
	 * validateRegisterDetails(mobileNumber,validateMatches.get("mobileNumber"),
	 * "mobileNumber"); System.out.println("Enter your adharNumber"); String
	 * adharNumber= scanner.next();
	 * //validateRegisterDetails(adharNumber,validateMatches.get("adharNumber"),
	 * "adharNumber"); /*System.out.println("Enter your panNumber"); String
	 * panNumber = scanner.next();
	 * validateRegisterDetails(panNumber,validateMatches.get("panNumber"),
	 * "panNumber"); System.out.println("Enter your addressLine1"); String
	 * addressLine1 = scanner.next();
	 * //validateRegisterDetails(firstName,validateMatches.get("addressLine1"),
	 * "addressLine1"); System.out.println("Enter your addressLine2"); String
	 * addressLine2 = scanner.next();
	 * //validateRegisterDetails(firstName,validateMatches.get("addressLine2"),
	 * "addressLine2"); System.out.println("Enter your city"); String city =
	 * scanner.next();
	 * validateRegisterDetails(city,validateMatches.get("city"),"city");
	 * System.out.println("Enter your state"); String state = scanner.next();
	 * validateRegisterDetails(state,validateMatches.get("state"),"state");
	 * System.out.println("Enter your country"); String country = scanner.next();
	 * validateRegisterDetails(country,validateMatches.get("country"),"country");
	 * System.out.println("Enter your country"); String pincode = scanner.next();
	 * validateRegisterDetails(pincode,validateMatches.get("pincode"),"pincode");
	 * NewRegister newRegister = new
	 * NewRegister(firstName,lastName,email,mobileNumber,adharNumber);
	 * loginController.checkForNewRegister(newRegister); }
	 */

	public void checkForLogin() {
		System.out.println("--------------------------------------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		loginController.checkCredentials(userName, password);
	}

	/*
	 * private void validateRegisterDetails(String input,String matches,String key)
	 * {
	 * 
	 * boolean isCorrect = input.matches( matches ); if(!isCorrect) {
	 * errorMessage("Please enter the correct " + key); getRegisterDetails(); }
	 * 
	 * }
	 */
}
