//https://spring.io/guides/gs/accessing-data-mysql/

package prs.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.purchaserequest.PurchaseRequest;
import prs.domain.purchaserequest.PurchaseRequestRepository;
import prs.domain.purchaserequest.PurchaseRequestSummary;
import prs.domain.purchaserequestlineitem.PurchaseRequestLineItem;
import prs.domain.purchaserequestlineitem.PurchaseRequestLineItemRepository;
import prs.util.PRSMaintenanceReturn;

@Controller    
@RequestMapping(path="/PurchaseRequests") 
public class PurchaseRequestController extends BaseController {
	@Autowired 
	private PurchaseRequestRepository purchaseRequestRepository;
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequest> getAllPurchaseRequests() {
		// This returns a JSON or XML with the users
		return purchaseRequestRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<PurchaseRequest> getPurchaseRequest(@RequestParam int id) {
		PurchaseRequest pr = purchaseRequestRepository.findOne(id);
		return getReturnArray(pr);
	}	
	
	@GetMapping(path="/Summary")
	public @ResponseBody List<PurchaseRequestSummary> getPurchaseRequestSummary(@RequestParam int id){
		PurchaseRequestSummary prs = new PurchaseRequestSummary();
		PurchaseRequest pr = purchaseRequestRepository.findOne(id);
		prs.setPurchaseRequest(pr);
		List<PurchaseRequestLineItem> prlis = 
				purchaseRequestLineItemRepository.findAllByPurchaseRequestID(pr.getId());
		prs.setLineItems(prlis);
		return getReturnArray(prs);		
	}

	@PostMapping(path="/Add")
	public @ResponseBody PRSMaintenanceReturn addNewPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		purchaseRequest.setSubmittedDate(ts);
		try {
			purchaseRequestRepository.save(purchaseRequest);
			System.out.println("Purchase Request saved: " + purchaseRequest);
		}
		catch (Exception e) {
			purchaseRequest = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequest);
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody PRSMaintenanceReturn updatePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		try {
			purchaseRequestRepository.save(purchaseRequest);
			System.out.println("Purchase Request updated: " + purchaseRequest);
		}
		catch (Exception e) {
			purchaseRequest = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequest);
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deletePurchaseRequest(@RequestParam int id) {
		PurchaseRequest purchaseRequest = purchaseRequestRepository.findOne(id);
		try {
			purchaseRequestRepository.delete(purchaseRequest);
			System.out.println("Purchase Request deleted: " + purchaseRequest);
		}
		catch (Exception e) {
			purchaseRequest = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequest);
	}

	
}