package es.uam.eps.padsof.testers;
import es.uam.eps.padsof.application.*;
import java.time.*;



import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class UserTest {
	User uo;
	
	@Before
	public void setUp() {
		uo = new User("pepe", "123456", "34684579E", "46-926439-522364359-3", false, "O");
	}
	
	@Test
	public void TestConstructorAndGetters() {
		assertNotNull(uo);
		assertEquals(uo.getNickname(), "pepe");
		assertEquals(uo.getPassword(), "123456");
		assertEquals(uo.getId(), "34684579E");
		assertEquals(uo.getCreditCard(), "46-926439-522364359-3");
		assertFalse(uo.getBlocked());
		assertNotNull(uo.getRoles());
		assertTrue(uo.getRoles().contains(Role.LANDLORD));
	}
	
	public void TestSetters() {
		
	}

}
