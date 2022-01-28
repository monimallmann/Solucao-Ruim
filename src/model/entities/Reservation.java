package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer numQuarto;
	private Date checkin;
	private Date checkout;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	public Reservation(Integer numQuarto, Date checkin, Date checkout) {
		this.numQuarto = numQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getCheckin() {
		return checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public long duration() {
		long dif = checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	public void atualizacao(Date checkin, Date checkout) throws DomainException {
		Date now = new Date();
		if(checkin.before(now)||checkout.before(now)) {
			throw new DomainException("Atualização de reservas somente em datas futuras.");
		}
		if(!checkout.after(checkin)) {
			throw new DomainException("Data do check-out deve ser depois do check-in.");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}
	@Override
	public String toString() {
		return "Quarto: " + numQuarto+ " Check-in: "+sdf.format(checkin)+" Check-out: "+sdf.format(checkout)+", "+ duration()+" noites";
	}
}
