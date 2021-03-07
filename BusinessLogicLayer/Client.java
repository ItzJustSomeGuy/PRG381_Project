package BusinessLogicLayer;

import java.io.Serializable;

//Client
public class Client implements Serializable{
	String clientid;
	String name;
	String surname;
	int phoneNumber;
	String email;
//	String address;

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/*
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
*/
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client(String clientid, String name, String surname, int phoneNumber, String email/*, String address*/) {
		this.clientid = clientid;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
	//	this.address = address;
	}
}