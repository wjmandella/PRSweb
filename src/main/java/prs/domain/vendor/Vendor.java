package prs.domain.vendor;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendor implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //"IDENTITY" allows the database (MySQL) to manage the id
	private int id;
	private String code;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	@Column(name="ispreapproved")
	private boolean preApproved;
	
	public Vendor() {
		id = 0;
		code = "";
		name = "";
		address = "";
		city = "";
		state = "";
		zip = "";
		phone = "";
		email = "";
		preApproved = false;
		
	}
	
//	public Vendor(String code, String name, String address, String city, String state,
//					String zip, String phone, String email, boolean preapproved) {
//		super();
//		this.code = code;
//		this.name = name;
//		this.address = address;
//		this.city= city;
//		this.state = state;
//		this.zip = zip;
//		this.phone = phone;
//		this.email = email;
//		this.preApproved = preapproved;	
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPreApproved() {
		return preApproved;
	}

	public void setPreApproved(boolean preApproved) {
		this.preApproved = preApproved;
	}

	public String toString() {	
		String msg = 
				"VENDOR:\n"
				+ "[id: " + id + ", code: " + code + ", name: " + name + "\n"
				+"city: " + city + ",state: " + state + ", zip code: " + zip + "\n"
				+ "phone: " + phone + ", email: " + email + "\n"
				+"preApproved?: " + preApproved + "]";
		return msg;
	}
	
	
}
