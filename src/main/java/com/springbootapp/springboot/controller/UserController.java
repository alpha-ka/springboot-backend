package com.springbootapp.springboot.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springbootapp.springboot.dao.UserRepository;
import com.springbootapp.springboot.environmentset.UserConInterface;
import com.springbootapp.springboot.exception.ResourceNotFoundException;

import com.springbootapp.springboot.model.User;


//@CrossOrigin (origins ="https://localhost:4200")
@RestController
//@Controller //if you use this then we should mention response body to get   
public class UserController {

	//we inject user repo
	@Autowired
	UserConInterface userconinterface;
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Value("${spring.message}")
	private String message;
	
	//Show home page
	@RequestMapping("/")
	public String homepage()
	{
		
		return "Hello World "+message+" "+userconinterface.getGreeting();
		
	}
	 
	@RequestMapping("/home")
	public ModelAndView home()
	{
		
		ModelAndView mv=new ModelAndView("home");
		return mv;
		
	}
	
	//Get all users
	@GetMapping("/showUsers")
	//@ResponseBody
	public List<User> getUsers()
	{
		return this.userRepo.findAll();
	}
	
	//Get user by ID
	@GetMapping("/showUser/{id}")
	public User getUserByID(@PathVariable(value="id") long ID )
	{
		//findByID is optional so we have to use optional array or else handle exception
		return this.userRepo.findById(ID)
					.orElseThrow(()-> new ResourceNotFoundException("User not found with ID:"+ID));
	}			
	//Create User
	@PostMapping("/postUser")
	public User createUser(@RequestBody User user)
	{		
		return this.userRepo.save(user);
	}
	
	//Update User
	
	@PostMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable ("id") long ID)
	{
		 User existingUser=this.userRepo.findById(ID)
				 			.orElseThrow(() -> new ResourceNotFoundException("User not found with ID:"+ID));
		 existingUser.setFirstname(user.getFirstname());
		 existingUser.setLastname(user.getLastname());
		 existingUser.setEmail(user.getEmail());
		 existingUser.setStatus(user.getStatus());
		 return this.userRepo.save(existingUser);
		 
	}
	
	//Delete the user
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<User> deleteUser(@PathVariable("id") long ID)
//	{
//		User existingUser=this.userRepo.findById(ID)
//						.orElseThrow(()->new ResourceNotFoundException("User not found with ID:"+ID));
//		this.userRepo.delete(existingUser);
//		return ResponseEntity.ok().build(existingUser);
//		
//	}
//	
//	
	@DeleteMapping("/deleteUser/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable("id") long ID)
	{
		User existingUser=this.userRepo.findById(ID)
						.orElseThrow(()->new ResourceNotFoundException("User not found with ID:"+ID));
		this.userRepo.delete(existingUser);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted successfully", Boolean.TRUE);
		return response;
	}
	
	
	@GetMapping("/activeUsers")
	public List<User> getActiveUsers()
	{	
		return this.userRepo.findAllActiveUsers();
	}
	
	
	@GetMapping("/usersReport")
	public List<User> getUsersReport()
	{	
		
		return this.userRepo.usersReport();
	}
	
}
