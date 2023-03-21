package com.slakshmi.flightreservation.bookingTransaction;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.flightreservation.dto.BookingParameters;
import com.slakshmi.flightreservation.dto.Flight;
import com.slakshmi.flightreservation.dto.Passenger;
import com.slakshmi.flightreservation.dto.TicketDetails;
import com.slakshmi.flightreservation.repository.FlightRepository;

public class BookTicketView implements BookTicketViewCallBack {
	private int ticketID=1;
	private BookTicketControllerCallBack bookTicketController;
	Scanner scanner = new Scanner(System.in);
	private String userName = "";
	
	public BookTicketView(){
		bookTicketController = new BookTicketController(this);
	}

	public void create(String userName)  {
		this.userName = userName;
		bookingIndex();
	}

	public void bookingIndex()  {
		System.out.println("---------------------------------");
		System.out.println("Enter the option---->");
		System.out.println("1.Booking");
		System.out.println("2.Cancel");
		System.out.println("3.Show Booking");
		System.out.println("4.HomePage");
		int bookingIndexOption = scanner.nextInt();
		bookTicketController.processbookingIndex(bookingIndexOption,userName);
	}
	
	public BookingParameters getTravelDetails() {
		System.out.println("---------------------------------");
		System.out.println("Enter the journey date (dd/mm/yyyy)");
		String date=scanner.next();
		System.out.println("Enter the from location");
		String fromLocation = scanner.next();
		System.out.println("Enter the to location");
		String toLocation = scanner.next();
		System.out.println("Enter no of tickets");
		int noOfTickets=scanner.nextInt();
		BookingParameters bookingParameters = new BookingParameters(date,fromLocation,toLocation,noOfTickets,null,userName);
		return bookingParameters;
	}
	public String bookTicket() {
		System.out.println("---------------------------------------");
		System.out.println("Fill the travel details");
		System.out.println();
		System.out.println("Enter the Flight id");
		String flightId=scanner.next();
		return flightId;
	}

	public void getPassengerDetails(BookingParameters bookingParameters) {
		System.out.println("----------------------------------");
		System.out.println("Passenger details-->");
		int noOfTickets =bookingParameters.getNoOfTickets();
		List<List> ticketdetails=null;
		while(noOfTickets>0) {
			System.out.println("Enter passenger name");
			String passengerName=scanner.next();
			System.out.println("Enter passenger age");
			int passengerAge=scanner.nextInt();
			boolean genderFlag=true;
			String passengerGender="";
			while(genderFlag) {
			System.out.println("Enter passenger gender M/F");
			char gender =scanner.next().charAt(0);
			if(gender=='m'|| gender=='M')
				{passengerGender="MALE";
			    genderFlag=false;}
				else if(gender=='f'|| gender=='F') {
				passengerGender="FEMALE";
				genderFlag=false;}
				else
					System.out.println("Please enter the correct format for gender");}
			Passenger passenger = new Passenger(passengerName,passengerAge,passengerGender,ticketID);
			ticketID++;
			noOfTickets--;
		    bookTicketController.addPassenger(passenger,bookingParameters);
		}
	}

	public void printAvailableFlightDetails(List<Flight> flightdetails) {
		System.out.println("------------------------------------");
		System.out.println("Flight details");
		//System.out.println("FlightId" +"\t | " +"FlightName" +"\t | " + "From" + "\t | " +"To" +"\t | " +"Available Seats");
		
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n",
                "FlightId","FlightName","FromLocation","ToLocation","Depature","Date","Price","AvailableSeats");
		
		for(Flight flight:flightdetails) {
			
			System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %n",
					flight.getFlightId(),flight.getFlightName(),flight.getFromLocation(),flight.getToLocation(),
					flight.getDepartureTime(),flight.getDate(),flight.getPrice(),flight.getAvailableSeats());
			
		}
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
					bookingParamters.getDate());
		}
	}

	public void errorMessage(String errorMessage) {
		
		System.out.println("----------------------------------------");
		System.out.println(errorMessage);
		bookingIndex();
	}
	
    public void successfulMessage(String message) {
		
    	System.out.println("----------------------------------------");
		System.out.println(message);
	}


}
