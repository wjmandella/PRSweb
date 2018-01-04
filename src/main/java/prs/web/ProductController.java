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
import prs.util.PRSMaintenanceReturn;

@Controller 
@RequestMapping(path="/Products") 
public class ProductController extends BaseController{
	@Autowired 
	private ProductRepository productRepository;

	@PostMapping(path="/Add") // Map ONLY POST Requests
	public @ResponseBody PRSMaintenanceReturn addNewProduct (@RequestBody Product product) {

		try {
			productRepository.save(product);
			System.out.println("Product saved: " + product);
		}
		catch (Exception e) {
			product = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(product) ;
	}

	@GetMapping(path="/List")
	public @ResponseBody Iterable<Product> getAllProducts() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Product> getProduct(@RequestParam int id) {
		Product p = productRepository.findOne(id);
		return getReturnArray(p) ;
	}	
	
	@PostMapping(path="/Change")
	public @ResponseBody PRSMaintenanceReturn updateProduct(@RequestBody Product product) {
		try {
			productRepository.save(product);
			System.out.println("Product updated: " + product);
		}
		catch (Exception e) {
			product = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(product);
	}
	
	
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deleteProduct(@RequestParam int id) {
	
		Product p = productRepository.findOne(id);
		try {	
			productRepository.delete(p);
			System.out.println("Product (ID:"+id +") was deleted.");
		} 
		catch (Exception e) {
			p = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(p);
	}	
}