//https://spring.io/guides/gs/accessing-data-mysql/

package prs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.product.Product;
import prs.domain.product.ProductRepository;
import prs.domain.vendor.Vendor;
import prs.domain.vendor.VendorRepository;
import prs.domain.vendor.VendorSummary;
import prs.util.PRSMaintenanceReturn;


@Controller   
@RequestMapping(path="/Vendors") 
public class VendorController extends BaseController{
	@Autowired 
	private VendorRepository vendorRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path="/Add") 
	public @ResponseBody PRSMaintenanceReturn addNewVendor(@RequestBody Vendor vendor) {		
		try {
			vendorRepository.save(vendor);
			System.out.println("Vendor added: "+ vendor);
		}
		catch (Exception e) {
			vendor = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(vendor);
	}

	@GetMapping(path="/List")
	public @ResponseBody Iterable<Vendor> getAllVendors() {
		// This returns a JSON or XML with the users
		return vendorRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Vendor> getVendor(@RequestParam int id) {
		Vendor v = vendorRepository.findOne(id);
		return getReturnArray(v);
	}	
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deleteVendor(@RequestParam int id) {
		Vendor vendor = vendorRepository.findOne(id);
		try {
			vendorRepository.delete(vendor);
			System.out.println("Vendor deleted: "+ vendor);
		}
		catch (Exception e) {
			vendor = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(vendor);
	}
	
	@PostMapping(path="/Change") 
	public @ResponseBody PRSMaintenanceReturn updateVendor(@RequestBody Vendor vendor) {
		try {
			vendorRepository.save(vendor);
			System.out.println("Vendor updated: "+ vendor);
		}
		catch (Exception e) {
			vendor = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(vendor);
	}
	
	@GetMapping(path="/Summary")
	public @ResponseBody List<VendorSummary> getVendorSummary(@RequestParam int id) {
		VendorSummary vs = new VendorSummary();
		Vendor vendor = vendorRepository.findOne(id);
		vs.setVendor(vendor);
		List<Product> products = productRepository.findAllByVendorID(vendor.getId());
		vs.setProducts(products);
		return getReturnArray(vs);	
	}
	
	@GetMapping(path="/GetNot")
	public @ResponseBody List<Product> getVendorNot(@RequestParam int id) {
		List<Product> products = productRepository.findAllByVendorIDNot(id);
		return products;
	}
}