//https://spring.io/guides/gs/accessing-data-mysql/

package prs.web;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(path="/PurchaseRequestsLineItems") 
public class PurchaseRequestLineItemController extends BaseController {
	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllPurchaseRequests() {
		// This returns a JSON or XML with the users
		return purchaseRequestLineItemRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<PurchaseRequestLineItem> getPurchaseRequestLineItem(@RequestParam int id) {
		PurchaseRequestLineItem prli = purchaseRequestLineItemRepository.findOne(id);
		return getReturnArray(prli);
	}	
	
	@PostMapping(path="/Add")
	public @ResponseBody PRSMaintenanceReturn addNewPurchaseRequestLineItem
	(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem, HttpServletRequest req) {

		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			System.out.println("Purchase Request Line Item added: " + purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody PRSMaintenanceReturn updatePurchaseRequestLineItem
	(@RequestBody PurchaseRequestLineItem purchaseRequestLineItem) {
		try {
			purchaseRequestLineItemRepository.save(purchaseRequestLineItem);
			System.out.println("Purchase Request Line Item updated: " + purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deletePurchaseRequestLineItem(@RequestParam int id) {
		PurchaseRequestLineItem purchaseRequestLineItem = purchaseRequestLineItemRepository.findOne(id);
		try {
			purchaseRequestLineItemRepository.delete(purchaseRequestLineItem);
			System.out.println("Purchase Request Line Item deleted: " + purchaseRequestLineItem);
		}
		catch (Exception e) {
			purchaseRequestLineItem = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(purchaseRequestLineItem);
	}

	
}