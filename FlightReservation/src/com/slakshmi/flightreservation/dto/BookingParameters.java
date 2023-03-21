package com.slakshmi.flightreservation.dto;

public class BookingParameters {
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	private String flightId;
	private int noOfTickets;
	private String fromLocation;
	private String toLocation;
	private String date;
	private String departureTime;
	private String arrivalTime;
	private String userName;
	
	public BookingParameters(String flightId, int noOfTickets) {
		super();
		this.flightId = flightId;
		this.noOfTickets = noOfTickets;
	}

	public BookingParameters(String date, String fromLocation, String toLocation, int noOfTickets,String flightId,String userName) {
		this.setDate(date);
		this.setFromLocation(fromLocation);
		this.setToLocation(toLocation);
		this.noOfTickets=noOfTickets;
		this.flightId=flightId;
		this.setUserName(userName);
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
