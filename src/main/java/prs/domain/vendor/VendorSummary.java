package prs.domain.vendor;

import java.util.List;

import prs.domain.product.Product;

public class VendorSummary {
	private Vendor vendor;
	private List<Product> products;
	
	public VendorSummary() {
		
	}
	
	public VendorSummary(Vendor vendor, List<Product> products) {
		super();
		this.vendor = vendor;
		this.products = products;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
