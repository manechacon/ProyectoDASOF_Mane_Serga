package es.uam.eps.padsof.application;
import java.time.*;
import es.uam.eps.padsof.telecard.*;
import java.io.*;
public abstract class Offer extends Commentable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User owner;
	private User booker;
	private Property property;
	private double price;
	private Status status;
	private LocalDate initdate;
	
	public Offer(User owner, Property property, double price, LocalDate initdate) {
		this.owner = owner;
		this.property = property;
		this.price = price;
		this.initdate = initdate;
	}
	public User getOwner() {
		return owner;
	}
	public Property getProperty() {
		return property;
	}
	public double getPrice() {
		return price;
	}
	private void setPrice(double price) {
		this.price = price;
	}
	public Status getStatus() {
		return status;
	}
	public void setOutOfDate() {
		this.status = Status.OUTOFDATE;
	}
	public void setActive() {
		this.status = Status.ACTIVE;
	}
	public void setBooked() {
		this.status = Status.BOOKED;
	}
	public void setHired() {
		this.status = Status.HIRED;
	}
	public void setNotAppoved() {
		this.status = Status.NOTAPPROVED;
	}
	public LocalDate getInitDate() {
		return initdate;
	}
	private void setInitDate(LocalDate initDate) {
		this.initdate = initDate;
	}
	public void modifyOffer(double price) {
		this.setPrice(price);
	}
	public void modifyOffer(LocalDate initDate) {
		this.setInitDate(initDate);
	}
	public void modifyOffer(LocalDate initDate, double price) {
		modifyOffer(initDate);
		modifyOffer(price);
	}
	public boolean hireOffer(User u) {
		if (u.getRoles().contains(Role.SEEKER)) {
			return false;
		}
		if(this.getStatus() != Status.BOOKED && this.getStatus() != Status.ACTIVE) {
			return false;
		}
		if(this.getStatus() == Status.BOOKED) {
			if(this.booker.compareTo(u)==0) {
				return false;
			}
		}
		
		int i = 0;
		String s = new String("Hire Offer");
		try {
			TeleChargeAndPaySystem.charge(u.getCreditCard(),s,getPrice());
		}
		catch(FailedInternetConnectionException e){
			i++;
			if (i>10) {
				return false;
			}
			hireOffer(u);
			
		}
		catch(InvalidCardNumberException e) {
			u.setBlocked();
			return false;
		}
		catch(OrderRejectedException e) {
			u.setBlocked();
			return false;
		}
		return true;
	}
	public boolean bookOffer(User u) {
		if (u.getRoles().contains(Role.SEEKER)) {
			return false;
		}
		if (this.getStatus() != Status.ACTIVE ) {
			return false;
		}
		this.booker = u;
		this.setBooked();
		return true;
	}
}