package es.uam.eps.padsof.application;
import java.util.*;
import java.io.*;
public class User implements Serializable, Comparable<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeSet<Role> roles;
	private ArrayList<Offer> offers;
	private ArrayList<Property> properties;
	private String nickname;
	private String password;
	private String id;
	private String creditCard;
	private Boolean blocked;
	
	
	
	public TreeSet<Role> getRoles() {
		return roles;
	}

	public void setRoles(TreeSet<Role> roles) {
		this.roles = roles;
	}

	public ArrayList<Offer> getOffers() {
		return offers;
	}

	public void setOffers(ArrayList<Offer> offers) {
		this.offers = offers;
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked() {
		this.blocked = true;
	}
	public void setUnblocked() {
		this.blocked = false;
	}
	

	public User(String nickname,String password,String id,String creditCard,Boolean blocked, String role) {
		this.nickname = nickname;
		this.password = password;
		this.id = id;
		this.creditCard = creditCard;
		this.blocked = false;
		roles = new TreeSet<Role>();
		if (role.compareTo("D")==0) {
			roles.add(Role.SEEKER);	
		}
		if (role.compareTo("O")==0) {
			roles.add(Role.LANDLORD);	
		}
		if (role.compareTo("OD")==0) {
			roles.add(Role.SEEKER);	
			roles.add(Role.LANDLORD);
		}
		
		
	}

	@Override
	public int compareTo(User u) {
		return this.id.compareTo(u.id);
	}
	
}
