package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-in date está depois do Checkout");
		}

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
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
		 long diff = checkOut.getTime()-checkIn.getTime();
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	//	return TimeUnit.DAYS.convert(checkOut.getTime() - checkIn.getTime(), TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		Date hj = new Date();

		if (checkIn.before(hj) || checkOut.before(hj)) {
			throw new DomainException("Erro na Reserva : Coloque data futura");
		} else if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro na Reserva : CheckOut está antes do Checkin");

		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkin: " + sdf.format(checkIn) + ", checkout: " + sdf.format(checkOut) + ", "
				+ duration() + " nights";
	}
}
