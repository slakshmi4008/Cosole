package com.slakshmi.flightreservation.CancelTransaction;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.flightreservation.bookingTransaction.BookTicketView;
import com.slakshmi.flightreservation.dto.BookingParameters;
import com.slakshmi.flightreservation.dto.Passenger;
import com.slakshmi.flightreservation.dto.TicketDetails;

public class CancelTicketView implements CancelTicketViewCallBack {
	private Scanner input = new Scanner(System.in);
	private CancelTicketControlerCallBack cancelTicketControler;

	public CancelTicketView() {
		cancelTicketControler = new CancelTicketControler(this);
	}

	public void cancelIndex(String userName) {
		System.out.println("---------------------------------");
		System.out.println(" Show Booked tickets");
		cancelTicketControler.showBookedTicket(userName);
	}

	public void noBookings(String errorMessage) {
		System.out.println("---------------------------------");
		System.out.println( errorMessage);
		BookTicketView bookTicketView = new BookTicketView();
		bookTicketView.bookingIndex();
	}

	public void bookingTicketInfo(List<TicketDetails> ticketDetails) {
		System.out.println("---------------------------------");
		System.out.println("Booking details-->");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n",
				"TicketId","FlightId","Name","Age","Gender","FromLocation","ToLocation","Date");
		for (TicketDetails bookInfo : ticketDetails) {
			Passenger passenger = bookInfo.getPassenger();
			BookingParameters bookingParamters = bookInfo.getBookingParameters();
			
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n",
					passenger.getTicketID(),bookingParamters.getFlightId(),passenger.getPassengerName()
					,passenger.getAge(),passenger.getGender(),bookingParamters.getFromLocation(),bookingParamters.getToLocation(),
					bookingParamters.getDate(),bookingParamters.getUserName());
		}
		getTicketId();
	}

	private void getTicketId() {
		System.out.println("---------------------------------");
		System.out.println("Enter TicketId to cancel Ticket");
		int cancelId = input.nextInt();
		cancelTicketControler.cancelTicket(cancelId);
	}

	public void cancellSuccesfully(String succesMessage) {
		System.out.println("---------------------------------");
		System.out.println(succesMessage);
		BookTicketView bookTicketView = new BookTicketView();
		bookTicketView.bookingIndex();
	}

	public void cancelFailure(String failureMessage) {
		System.out.println("---------------------------------");
		System.out.println(failureMessage);
		BookTicketView bookTicketView = new BookTicketView();
		bookTicketView.bookingIndex();
	}
}
