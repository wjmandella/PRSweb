package prs.domain.purchaserequest;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PurchaseRequest implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int userID;
	private String description;
	private String justification;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp dateNeeded;
	private String deliveryMode;
	private int statusID;
	private double total;
	private Timestamp submittedDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Timestamp submitted;

	public PurchaseRequest() {
		id = 0;
		userID = 0;
		description = "";
		justification = "";
		dateNeeded = new Timestamp(System.currentTimeMillis());
		deliveryMode = "";
		statusID = 0;
		total = 0.0;
		submittedDate = new Timestamp(System.currentTimeMillis());
	}

	public PurchaseRequest(int id, int userID, String descr, String justif, Timestamp dateNeeded,
							String dlvryMode, int statusID, double tot, Timestamp submittedDate) {
		
		this.id = id;
		this.userID = userID;
		this.description = descr;
		this.justification = justif;
		this.dateNeeded = dateNeeded;
		this.deliveryMode = dlvryMode;
		this.statusID = statusID;
		this.total = tot;
		this.submittedDate= submittedDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Timestamp getDateNeeded() {
		return dateNeeded;
	}

	public void setDateNeeded(Timestamp dateNeeded) {
		this.dateNeeded = dateNeeded;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Timestamp getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}

//	public List<PurchaseRequestLineItem> getPrLineItems() {
//		return lineItems;
//	}
//
//	public void setPrLineItems(List<PurchaseRequestLineItem> lineItems) {
//		this.lineItems = lineItems;
//	}


	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		String msg =
				"\nPURCHASE REQUEST SUMMARY: "
				+ "ID: " + id + ", User: " + userID + "\n"
				+ "Description: " + description + "\n"
				+ "Total: " + currency.format(total) + "\n";
		return msg;		
	}	
}
