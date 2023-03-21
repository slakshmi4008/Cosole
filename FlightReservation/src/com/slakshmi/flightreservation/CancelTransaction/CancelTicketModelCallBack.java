package com.slakshmi.flightreservation.CancelTransaction;

public interface CancelTicketModelCallBack {

	void showBookedTicket(String userName);

	void cancelTicket(int cancelId);

}
