package com.slakshmi.flightreservation.bookingTransaction;

import java.util.List;

import com.slakshmi.flightreservation.CancelTransaction.CancelTicketView;
import com.slakshmi.flightreservation.bookingTransaction.BookTicketModel.BookTicketModelControlerCallBack;
import com.slakshmi.flightreservation.dto.BookingParameters;
import com.slakshmi.flightreservation.dto.Flight;
import com.slakshmi.flightreservation.dto.Passenger;
import com.slakshmi.flightreservation.dto.TicketDetails;
import com.slakshmi.flightreservation.login.LoginView;

public class BookTicketController implements BookTicketControllerCallBack, BookTicketModelControlerCallBack {
	private BookTicketModelCallBack bookTicketModel;
	private BookTicketViewCallBack bookTicketView;
	private BookingParameters bookingParameters;
	
	public BookTicketController(BookTicketViewCallBack bookTicketView) {
		this.bookTicketModel = new BookTicketModel(this);
		this.bookTicketView=bookTicketView;
	}

	public void processbookingIndex(int bookingIndexOption,String userName) {
	
		if(bookingIndexOption==1) {
			processBooking();
		}
		else if(bookingIndexOption==2) {
			processCancelBooking(userName);
		}
		else if(bookingIndexOption==3) {

			showBooking(bookingParameters);
		}
        else if(bookingIndexOption==4) {
        	//bookTicketView.successfulMessage("Thank you for visiting us");
        	LoginView loginView =new LoginView();
        	loginView.create();
		}
	}
	private void processCancelBooking(String userName) {
		CancelTicketView cancel = new CancelTicketView();
		cancel.cancelIndex(userName);
	}

	private void processBooking() {
		bookingParameters=bookTicketView.getTravelDetails();// get travel details from user
		List<Flight> flightdetails =bookTicketModel.getAvailableFlightDetails(bookingParameters);//get available flight from db
		if(flightdetails.isEmpty())
			bookTicketView.errorMessage("There is no flight for the requested details.Please try again");
		
		bookTicketView.printAvailableFlightDetails(flightdetails);
		String flightId=bookTicketView.bookTicket();//get booking details from user
		bookingParameters.setFlightId(flightId);
		
		int availableTickets=isTicketAvailable(bookingParameters);// check if number of tickets requested by user is available
        
		if(availableTickets>=bookingParameters.getNoOfTickets()) {
			
			bookTicketView.getPassengerDetails(bookingParameters);//get passenger details from user
			payment(bookingParameters);
        	bookTicketModel.updateFlightDetails(bookingParameters);// to reduce no of available seats in selected flight  	
        	showBooking(bookingParameters);
        	
        }else {
        	bookTicketView.errorMessage("The number of tickets requested is greater than available tickets");
        }	
	}

	private void payment(BookingParameters bookingParameters) {
		float ticketPrice =bookTicketModel.getPamentDetails(bookingParameters);
		float amountPayable = ticketPrice*bookingParameters.getNoOfTickets();
		if(amountPayable>=0)
			bookTicketView.successfulMessage("The total payable amount is INR " +amountPayable);
		    bookTicketView.successfulMessage("Your tickect is booked successfully"); 
	}

	private void showBooking(BookingParameters bookingParameters) {
		String userName=bookingParameters.getUserName();
		List<TicketDetails> ticketDetails=bookTicketModel.getBookingInfo(userName);
		if (ticketDetails.size() == 0) {
			bookTicketView.errorMessage("No booking from your account");
		} else {
			bookTicketView.bookingTicketInfo(ticketDetails);
		}
    	
    	bookTicketView.bookingIndex();
		
	}

	public int isTicketAvailable(BookingParameters bookingParameters) {
	
		List<Flight> flightdetails = bookTicketModel.getFlightDetails();
		int availableSeats=0;
		
		for(Flight flight :flightdetails) {
		
			if(flight.getFlightId().equalsIgnoreCase(bookingParameters.getFlightId())){
				availableSeats=flight.getAvailableSeats();
			}
		}
	  return availableSeats;	
	}

	public void addPassenger(Passenger passenger, BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
	   bookTicketModel.addPassenger(passenger,bookingParameters);
		
	}

}
