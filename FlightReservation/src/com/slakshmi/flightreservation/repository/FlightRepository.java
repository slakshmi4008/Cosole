package com.slakshmi.flightreservation.repository;

import java.util.ArrayList;
import java.util.List;

import com.slakshmi.flightreservation.dto.Admin;
import com.slakshmi.flightreservation.dto.BookingParameters;
import com.slakshmi.flightreservation.dto.Credentials;
import com.slakshmi.flightreservation.dto.Flight;
import com.slakshmi.flightreservation.dto.Passenger;
import com.slakshmi.flightreservation.dto.TicketDetails;
import com.slakshmi.flightreservation.dto.User;

public class FlightRepository {
	private static FlightRepository flightDbInstance;
	private List<Credentials> adminCredentials = new ArrayList<Credentials>();	
	private List<User> userCredentials = new ArrayList<User>();
	private List<Flight> flightDetails = new ArrayList<Flight>();
	private List<TicketDetails> ticketDetails = new ArrayList();
	private List<Passenger> passengerDetails = new ArrayList<Passenger>();

	private FlightRepository() {

	}

	public static FlightRepository getInstance() {
		if (flightDbInstance == null) {
			flightDbInstance = new FlightRepository();
			flightDbInstance.initialSetup();
		}
		return flightDbInstance;
	}

	private void initialSetup() {
		// Adding Admin details to the list
		adminCredentials.add(new Credentials("0001", "admin", "ZSGS"));
		adminCredentials.add(new Credentials("0002", "lakshmi", "1234"));
		addFlight();

	}
	public void addFlight() {    
		flightDetails.add(new Flight ("JET001","JetAirways","Chennai","Mumbai","22/02/2023","9.00AM","12.00",10,0,0,2500.00f));
		flightDetails.add(new Flight ("JET002","JetAirways","Chennai","Calcutta","22/02/2023","9.00AM","12.00",10,0,0,3000f));
	}

	public Admin checkValidAdmin(String userName, String password) {
		for (Credentials credential : adminCredentials) {
			if (credential.getUserName().equals(userName) && credential.getPassword().equals(password)) {
				return credential;
			}
		}
		return null;
	}
	public User checkValidUser(String userName, String password) {
		for (User user : userCredentials ) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	public List<Flight> getAvailableFlightDetails(BookingParameters bookingParameters){
		List<Flight> availableFlights=new ArrayList<>();
		for(Flight flight : flightDetails) {
			if(flight.getDate().equals(bookingParameters.getDate()) && 
					flight.getFromLocation().equalsIgnoreCase(bookingParameters.getFromLocation()) &&
							flight.getToLocation().equalsIgnoreCase(bookingParameters.getToLocation())) {
				availableFlights.add(flight);
			}
		}
		return availableFlights;
	}

	public List<Flight> getFlightDetails() {
		
		return flightDetails;
	}

	public void addPassenger(Passenger passenger, BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
		passengerDetails.add(passenger);
		updateTicketDetails(bookingParameters,passenger);
		
	}

	public void updateFlightDetails(BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
		for(Flight flight : flightDetails) {
			if(flight.getFlightId().equalsIgnoreCase(bookingParameters.getFlightId())) {
				int reduceAvailalbeSeat=flight.getAvailableSeats()-bookingParameters.getNoOfTickets();
				flight.setAvailableSeats(reduceAvailalbeSeat);
			}
		}
	}
	public void updateAvailableSeats(BookingParameters bookingParameters) {
		for(Flight flight : flightDetails) {
			if(flight.getFlightId().equalsIgnoreCase(bookingParameters.getFlightId())) {
				int increaseAvailalbeSeat=flight.getAvailableSeats()+1;
				flight.setAvailableSeats(increaseAvailalbeSeat);
			}
	    }
	}

	public  List<Passenger> getTicketDetails(BookingParameters bookingParameters) {

		return passengerDetails;
	}

	public void updateTicketDetails(BookingParameters bookingParameters,Passenger passenger) {
		
		ticketDetails.add(new TicketDetails(passenger,bookingParameters));
		
	}

	public void addUser(String userMail, String password) {
		userCredentials.add(new User(userMail, password));
		
	}

	public List<TicketDetails>  getBookingInfo(String userName) {
		List<TicketDetails> userTicketDetails = new ArrayList();
		for(TicketDetails bookingHistory : ticketDetails) {
			BookingParameters bookingParamters = bookingHistory.getBookingParameters();
			if(userName.equals(bookingParamters.getUserName()))
					userTicketDetails.add(bookingHistory);
		}
			return userTicketDetails;
	}

	public boolean cancelTicket(int cancelId) {
		// TODO Auto-generated method stub
		int i = 0;
		for (TicketDetails cancelTicket : ticketDetails) {
			Passenger passenger = cancelTicket.getPassenger();
			BookingParameters bookingParamters = cancelTicket.getBookingParameters();
			if (passenger.getTicketID() == cancelId) {
				ticketDetails.remove(i);
				passengerDetails.remove(i);
				updateAvailableSeats(cancelTicket.getBookingParameters());
				return true;
			}
			i++;
		}
		return false;
	}

	public float getTicketPrice(BookingParameters bookingParameters) {
		// TODO Auto-generated method stub
		for(Flight flight : flightDetails) {
			if(flight.getFlightId().equalsIgnoreCase(bookingParameters.getFlightId())) {
				float ticketPrice = flight.getPrice();
				return ticketPrice;
			}
	    }
		return -1;
	}
}
