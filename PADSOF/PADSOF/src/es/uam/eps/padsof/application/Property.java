package es.uam.eps.padsof.application;
import java.io.*;

public class Property implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User owner;
	private String type;
	private String postalCode;
	private String address;
	private String description;
	
	public Property(User owner, String type, String postalCode, String address, String description) {
		this.owner = owner;
		this.type = type;
		this.postalCode = postalCode;
		this.address = address;
		this.description = description;
	}
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
