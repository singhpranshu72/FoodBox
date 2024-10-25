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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.OnlineFoodApp.entity.Cart;
import com.ruby.OnlineFoodApp.exceptions.CartException;
import com.ruby.OnlineFoodApp.exceptions.ItemException;
import com.ruby.OnlineFoodApp.service.FoodCartService;



@RestController
@RequestMapping("/cart")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
public class FoodCartServiceController {
	
	@Autowired
	FoodCartService foodCartService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Cart> saveCartDetails(@RequestBody Cart fc) throws CartException
	{
	            Cart f= foodCartService.saveCart(fc);
	            	return new ResponseEntity<Cart>(f,HttpStatus.CREATED);
	            
	         
	}
	
	
	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<Cart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartException, ItemException{
	Cart updatedCart = foodCartService.addItem(cartId, itemId);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		Cart removedCart = foodCartService.clearCart(cartId);
		return new ResponseEntity<Cart>(removedCart, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{cartId}")
	public Cart getCartByCartId(@PathVariable ("cartId") Integer cartId) throws  CartException{
		
		
			return foodCartService.viewCart(cartId);
		
			
	}

}
