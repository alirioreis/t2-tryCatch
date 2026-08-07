package model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
	//	long diff = checkOut.getTime()-checkIn.getTime();
	//	return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		return TimeUnit.DAYS.convert(checkOut.getTime()-checkIn.getTime(),TimeUnit.MILLISECONDS);
	}
	public void updateDates(Date checkin, Date checkout) {
		this.checkIn = checkin;
		this.checkOut = checkout;
	}
	
}
