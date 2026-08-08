package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
	public String updateDates(Date checkin, Date checkout) {
		Date hj = new Date();
		
		if (hj.after(checkIn)||hj.after(checkOut)){
			return "Erro na Reserva : Coloque data futura";
		} else if (checkIn.after(checkOut)){
			return "Erro na Reserva : CheckOut está antes do Checkin";
			
		}	
				
		this.checkIn = checkin;
		this.checkOut = checkout;
		
		return null;
	}
	@Override
	public String toString () {
		return "Room "
				+ roomNumber
				+ ", checkin: "
				+ sdf.format(checkIn)
				+ ", checkout: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
