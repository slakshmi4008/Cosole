package com.slakshmi.flightreservation.bookingTransaction;

import java.util.List;

import com.slakshmi.flightreservation.dto.Admin;
import com.slakshmi.flightreservation.dto.BookingParameters;
import com.slakshmi.flightreservation.dto.Flight;
import com.slakshmi.flightreservation.dto.Passenger;
import com.slakshmi.flightreservation.dto.TicketDetails;
import com.slakshmi.flightreservation.dto.User;
import com.slakshmi.flightreservation.repository.FlightRepository;

public class BookTicketModel implements BookTicketModelCallBack {

private BookTicketModelControlerCallBack bookTicketController;
	
	public BookTicketModel(BookTicketController bookTicketController) {
		this.bookTicketController = bookTicketController;
	}

	public List<Flight> getAvailableFlightDetails(BookingParameters bookingParameters) {
		
		List<Flight> flightdetails  = FlightRepository.getInstance().getAvailableFlightDetails(bookingParameters);
		
		return flightdetails;
	}

	public void updateFlightDetails(BookingParameters bookingParameters) {
		
		FlightRepository.getInstance().updateFlightDetails(bookingParameters);
	}

	public void addPassenger(Passenger passenger, BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
		FlightRepository.getInstance().addPassenger(passenger,bookingParameters);
	}

	public List<Passenger>  getTicketDetails(BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
		List<Passenger> PassengerDetails = FlightRepository.getInstance().getTicketDetails(bookingParameters);
		return PassengerDetails;
	}

	public List<TicketDetails> getBookingInfo(String userName) {
		// TODO Auto-generated method stub
		return FlightRepository.getInstance().getBookingInfo(userName);
	}
	public interface BookTicketModelControlerCallBack {

		
	}
	@Override
	public List<Flight> getFlightDetails() {
		List<Flight> flightdetails  = FlightRepository.getInstance().getFlightDetails();
		return flightdetails;
	}

	@Override
	public float getPamentDetails(BookingParameters bookingParameters) {
		float ticketPrice =FlightRepository.getInstance().getTicketPrice(bookingParameters);
		return ticketPrice;
	}
}
