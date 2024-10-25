package com.ruby.OnlineFoodApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.OnlineFoodApp.entity.Customer;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;
import com.ruby.OnlineFoodApp.service.CustomerService;



@RestController
@RequestMapping("/customer")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
public class CustomerServiceController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException{
		 Customer newCustomer = customerService.addCustomer(customer);
		 return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		 Customer updatedCustomer = customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer removedCustomer = customerService.removeCustomerById(customerId);
		 return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer customer = customerService.viewCustomer(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/getByName/{customerName}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerName") String customerName) throws CustomerException{
		 Customer customer = customerService.getCustomerbyName(customerName);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/getByEmail/{customerEmail}")
	public ResponseEntity<Customer> viewCustomerbyEmail(@PathVariable("customerEmail") String customerEmail) throws CustomerException{
		 Customer customer = customerService.getCustomerbyEmail(customerEmail);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/login/{username}/{pwd}/{role}")
	public ResponseEntity<?> login(@PathVariable String username, @PathVariable String pwd, @PathVariable String role) throws CustomerException {
		Customer susr = new Customer();
		susr.setFullName(username);
		susr.setPassword(pwd);
		susr.setRole(role);
		System.out.println("********* " + susr);

		// Use findByUsername to retrieve the user wrapped in Optional
		Customer foundUser = customerService.getCustomerbyName(username);

		// Check if the user is present in Optional
		if (foundUser !=null) {
		
			System.out.println("Actual user " + foundUser);
			// Check if the password and role match
			if (foundUser.getPassword().equals(pwd) && foundUser.getRole().equals(role)) {

				return ResponseEntity.ok(foundUser); // Return the found user if credentials are valid
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentialssss");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.d.d.d");
		}
	}

}
