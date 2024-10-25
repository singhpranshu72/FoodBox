package com.ruby.OnlineFoodApp.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.entity.OrderDetails;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;
import com.ruby.OnlineFoodApp.exceptions.OrderException;
import com.ruby.OnlineFoodApp.service.OrderDetailService;


@RestController
@RequestMapping("/order")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
public class OrderDetailServiceController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	
	
	
	
	 @PostMapping("/save")
     public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order) throws OrderException{
     	
 
     		return new ResponseEntity<OrderDetails>(orderDetailService.addOrder(order), HttpStatus.CREATED);
     
     }
	 
	 
	 @PutMapping("/update")
     public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order) throws OrderException{
         
     		return new ResponseEntity<OrderDetails>(orderDetailService.updateOrder(order), HttpStatus.ACCEPTED);
     	
     		
     }
	 
	 
	 @DeleteMapping("/remove/{orderId}")
     public ResponseEntity<OrderDetails> deleteOrder(@PathVariable("orderId") Integer orderId ) throws OrderException{
     	
     
     		return new ResponseEntity<OrderDetails>(orderDetailService.removeOrder(orderId), HttpStatus.ACCEPTED);
     	
     }
	 
	 @GetMapping("/view/{orderId}")
     public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId) throws OrderException{
     	
     		return  new ResponseEntity<OrderDetails>(orderDetailService.viewOrder(orderId),HttpStatus.FOUND);
     
     }
	 
	 
	 @GetMapping("/viewbycustomer/{customerId}")
     public ResponseEntity<List<Food>> viewAllOrders(@PathVariable("customerId") Integer customerId) throws OrderException, CustomerException{
     	
    
     		return  new ResponseEntity<List<Food>>(orderDetailService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
     
     }

}
