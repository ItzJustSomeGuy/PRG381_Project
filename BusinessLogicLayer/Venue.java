package BusinessLogicLayer;

import java.io.Serializable;

//Venue
public class Venue implements Serializable{
	private String name;
	private String address;
	private String number;
	int venueID;

	//This class only contains getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getVenueID() {
		return venueID;
	}

	public void setVenueID(int venueID) {
		this.venueID = venueID;
	}

	//constructor
	public Venue(String name, String address, String number, int venueID) {
		this.name = name;
		this.address = address;
		this.number = number;
		this.venueID = venueID;
	}

	public Venue(String name) {
		this.name = name;
	}
	
}