package prs.domain.user;

import java.io.Serializable;
//import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	@Column(name="isreviewer") //@Column(name="IsReviewer")
	private boolean reviewer;
	@Column(name="isadmin") //@Column(name="IsAdmin")
	private boolean admin;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
//	private Timestamp dateCreated;
	
	public User() {
		userName ="";
		password = "";
	}
	
	public User(int id, String un, String pw) {
		this.id = id;
		this.userName = un;
		this.password = pw;
	}
	
	public User(int id, String un, String pw, String fN, String lN, String pn, String em, boolean rev, boolean adm) {
		this.id = id;
		this.userName = un;
		this.password = pw;
		this.firstName = fN;
		this.lastName = lN;
		this.phone = pn;
		this.email = em;
		this.reviewer = rev;
		this.admin = adm;

	}
	
	public User(String un, String pw, String fN, String lN, String pn, String em, boolean rev, boolean adm) {
		setUserName(un);
		setPassword(pw);
		setFirstName(fN);
		setLastName(lN);
		setPhone(pn);
		setEmail(em);
		setReviewer(rev);
		setAdmin(adm);	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public boolean isReviewer() {
		return reviewer;
	}
	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

//	public Timestamp getDateCreated() {
//		return dateCreated;
//	}
//
//	public void setDateCreated(Timestamp dateCreated) {
//		this.dateCreated = dateCreated;
//	}

	@Override  //helpful annotation
	public String toString() {
		String msg =
				  "\n-----------------------------------------------------\n"
		        + "---- User Information--------------------------------\n"
		        + "-----------------------------------------------------\n"
		        + "id: " + id + "\n"
		        + "username:\t" + getUserName() + "\n"
		        + "password:\t" + getPassword() + "\n"
				+ "Name:\t\t" + getFirstName() + " " + getLastName() + "\n"
		        + "Email Address:\t" + getEmail() + "\n"
		        + "Phone Number:\t" + getPhone() + "\n"
				+ "Reviewer: " + reviewer + "\n"
				+ "Admin: " + admin + "\n";
		return msg;				
	}	
	
}
