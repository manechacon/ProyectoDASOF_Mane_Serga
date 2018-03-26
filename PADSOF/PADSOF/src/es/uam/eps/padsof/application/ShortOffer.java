package es.uam.eps.padsof.application;
import java.time.*;

public class ShortOffer extends Offer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate finalDate;
	public ShortOffer(User owner, Property property, double price, LocalDate initdate, LocalDate finalDate) {
		super(owner, property, price, initdate);
		this.finalDate = finalDate;
	}
	public LocalDate getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
}
