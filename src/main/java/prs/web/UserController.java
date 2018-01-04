//https://spring.io/guides/gs/accessing-data-mysql/

package prs.web;

import java.util.List;

//import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import prs.domain.user.User;
import prs.domain.user.UserRepository;
import prs.util.PRSMaintenanceReturn;

@Controller    
@RequestMapping(path="/Users") 
public class UserController extends BaseController{
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path="/Add") // Map ONLY GET Requests
	public @ResponseBody PRSMaintenanceReturn addNewUser(@RequestBody User user) {		
		try {
			userRepository.save(user);
			System.out.println("User saved:  "+user);
		}
		catch (Exception e) {
			user = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(user);
	}
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<User> getUser(@RequestParam int id) {
		User u = userRepository.findOne(id);
		return getReturnArray(u);
	}
	
	@GetMapping(path="/Authenticate")
	public @ResponseBody List<User> authenticate(@RequestParam String username, 
													@RequestParam String password) {
		User u = userRepository.findByUserNameAndPassword(username, password);
		return getReturnArray(u);
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody PRSMaintenanceReturn deleteUser(@RequestParam int id) {
		User u = userRepository.findOne(id);
		try {
			userRepository.delete(u);
			System.out.println("User (ID:"+id +") was deleted.");
		}
		catch (Exception e) {
			u = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(u);
	}
	
	@PostMapping(path="/Change") 
	public @ResponseBody PRSMaintenanceReturn updateUser(@RequestBody User u) {
		try {
			userRepository.save(u);
			System.out.println("User updated: "+ u);
		}
		catch (Exception e) {
			u = null;
		}
		return PRSMaintenanceReturn.getMaintReturn(u);
	}
}