package es.uam.eps.padsof.application;
import java.util.*;
import java.io.*;
public class Application {
	private List<User> users; 
	private List<Offer> offers; 
	private List<Property> properties;
	private static ObjectInputStream imput; 
	
	public Application(List<User> users,  List<Offer> offers,  List<Property> properties) { /*Constructor*/
		this.users = users;
		this.offers = offers;
		this.properties = properties;
		
	}
	@SuppressWarnings("unchecked")
	public static Application loadApplication (String path) throws FileNotFoundException, IOException, ClassNotFoundException {
		imput = new ObjectInputStream (new FileInputStream(path));
		List<User> users = (List<User>) imput.readObject();
		List<Offer> offers = (List<Offer>) imput.readObject();
		List<Property> properties = (List<Property>) imput.readObject();
		return new Application(users, offers, properties);
	}
	public boolean saveApplication (String path) throws IOException { 
		ObjectOutputStream application = new ObjectOutputStream(new FileOutputStream(path));
		application.writeObject(this.users);
		application.writeObject(this.offers);
		application.writeObject(this.properties);
		application.close();
		return true;
	}
	public boolean addOffer(Offer o) {
		this.offers.add(o);
		return true;
	}
	public boolean addProperty(Property p) {
		this.properties.add(p);
		return true;
	}
}