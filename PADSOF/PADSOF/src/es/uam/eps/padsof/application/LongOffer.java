package es.uam.eps.padsof.application;

import java.time.*;

public class LongOffer extends Offer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int minStay;
	public LongOffer(User owner, Property property, double price, LocalDate initdate, int minStay) {
		super(owner, property, price, initdate);
		this.setMinStay(minStay);
	}
	public int getMinStay() {
		return minStay;
	}
	public void setMinStay(int minStay) {
		this.minStay = minStay;
	}
}	
