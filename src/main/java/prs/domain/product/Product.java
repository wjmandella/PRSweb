package prs.domain.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int vendorID;
	private String partNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;
		
	public Product() {
		id = 0;
		vendorID = 0;
		partNumber = "";
		name = "";
		price = 0.0;
		unit = "";
		photoPath = "";		
	}
	
	public Product(int id, int vendorID, String vendorPartNum, String name, 
									double price, String unit, String photopath, String photoPath) {
		this.id = id;
		this.vendorID = vendorID;
		this.partNumber = vendorPartNum;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.photoPath = photoPath;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	
//	public Vendor getVendor() {
//		return vendor;
//	}
//
//	public void setVendor(Vendor vendor) {
//		this.vendor = vendor;
//	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	public String toString() {
		String msg =
				"PRODUCT: [ID: " + id + ", vendor ID: " + vendorID 
				+ "Vendor Part Number: " + partNumber + ", Name: " + name
				+ ", Price: " +price + ", Unit: " + unit + ", Photopath: " 
				+ photoPath + "]";
		return msg;		
	}
}


