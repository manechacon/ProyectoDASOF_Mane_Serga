package es.uam.eps.padsof.testers;
import es.uam.eps.padsof.application.*;
import java.time.*;



import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class OfferTest {
	private Offer o;
	private User uo;
	private User ud;
	private User uod;
	private Property p;
	
	@Before
	public void setUp() {
		uo = new User("pepe", "123456", "34684579E", "46-926439-522364359-3", false, "O");
		ud = new User("juan", "654321", "34598379E", "46-926349-53423e459-3", false, "D");
		uod = new User("maria", "qwerty", "34937579E", "46-926439-526445359-3", false, "OD");
		p = new Property (uo, "short", "14940", "Av. Gonzalez 3", "Clean and New");
		o = new ShortOffer(uo, p, 123.45, LocalDate.now(), LocalDate.now().plusDays(15));
	}
	
	@Test
	public void testHireOffer() {
		o.getStatus();
		o.hireOffer(uo);
		o.getStatus();
	}
}
