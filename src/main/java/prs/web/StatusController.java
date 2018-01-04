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

import prs.domain.status.Status;
import prs.domain.status.StatusRepository;
import prs.util.PRSMaintenanceReturn;


@Controller    
@RequestMapping(path="/Status") 
public class StatusController extends BaseController{
	@Autowired 
	private StatusRepository statusRepository;

	@PostMapping(path="/Add") 
	public @ResponseBody PRSMaintenanceReturn addNewStatus (@RequestBody Status status) {
		
		try {
			statusRepository.save(status);
			System.out.println("Status saved: "+ status);
		}
		catch (Exception e) {
			status = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(status);
	}

	@GetMapping(path="/List")
	public @ResponseBody Iterable<Status> getAllStatus() {
		// This returns a JSON or XML with the users
		return statusRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Status> getStatus(@RequestParam int id) {
		Status s = statusRepository.findOne(id);
		return getReturnArray(s);
	}	
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deleteStatus(@RequestParam int id) {
		Status status = statusRepository.findOne(id);
		try {
			statusRepository.delete(status);
			System.out.println("Status deleted: "+ status);
		}
		catch (Exception e) {
			status = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(status);
	}	
	
	@PostMapping(path="/Change") 
	public @ResponseBody PRSMaintenanceReturn updateStatus(@RequestBody Status status) {
		try {
			statusRepository.save(status);
			System.out.println("Status updated: "+ status);
		}
		catch (Exception e) {
			status = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(status);
	}	
	
}