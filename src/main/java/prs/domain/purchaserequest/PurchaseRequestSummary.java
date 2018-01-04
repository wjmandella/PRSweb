package prs.domain.purchaserequest;

import java.util.List;

import prs.domain.purchaserequestlineitem.PurchaseRequestLineItem;

public class PurchaseRequestSummary {
	private PurchaseRequest purchaseRequest;
	private List<PurchaseRequestLineItem> lineItems;
	
	public PurchaseRequestSummary() {
		
	}

	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}
	
	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	
	public List<PurchaseRequestLineItem> getLineItems(){
		return lineItems;
	}
	
	public void setLineItems(List<PurchaseRequestLineItem> lineItems) {
		this.lineItems = lineItems;
	}
}

