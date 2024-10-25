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
import org.springframework.web.bind.annotation.RestController;

import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.exceptions.ItemException;
import com.ruby.OnlineFoodApp.service.ItemService;


@RestController
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
public class ItemServiceController {
	
	@Autowired
	ItemService itemService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Food> addItem(@RequestBody Food food) throws ItemException{
		Food newItem = itemService.addItem(food);
		return new ResponseEntity<Food>(newItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Food> updateItem(@RequestBody Food food) throws ItemException{
		Food updatedItem = itemService.updateItem(food);
		return new ResponseEntity<Food>(updatedItem, HttpStatus.OK);
	}
	
	@GetMapping("/view/{foodId}")
	public ResponseEntity<Food> getItem(@PathVariable("foodId") Integer foodId) throws ItemException{
		Food item = itemService.viewItem(foodId);
		return new ResponseEntity<Food>(item, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{foodId}")
	public ResponseEntity<Food> removeItem(@PathVariable("foodId") Integer foodId) throws ItemException{
		Food removedItem = itemService.removeItem(foodId);
		return new ResponseEntity<Food>(removedItem, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/viewall")
	public ResponseEntity<List<Food>> getAllItems() throws ItemException{
		List<Food> items = itemService.viewAllItems();
		return new ResponseEntity<List<Food>>(items, HttpStatus.OK);
		
	}
}
