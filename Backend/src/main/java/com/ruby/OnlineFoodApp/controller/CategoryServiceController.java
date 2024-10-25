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

import com.ruby.OnlineFoodApp.entity.Category;
import com.ruby.OnlineFoodApp.exceptions.CategoryException;
import com.ruby.OnlineFoodApp.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*",
origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE} )
public class CategoryServiceController {
	
	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
		Category newCategory = categoryService.addCategory(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		Category category = categoryService.viewCategory(categoryId);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/remove/{categoryId}")
	public ResponseEntity<Category> removeCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		Category removedCategory = categoryService.removeCategory(categoryId);
		return new ResponseEntity<Category>(removedCategory, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Category>> getAllCategories() throws CategoryException{
		List<Category> categories = categoryService.viewAllCategory();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}
	
	
	@GetMapping("/next-cid")
    public ResponseEntity<Integer> getNextCategoryId() throws CategoryException{
 	   Integer nextId = categoryService.findNextCategoryId()+1;
 	   return ResponseEntity.ok(nextId);
    }
	
	@GetMapping("/getByName/{name}")
       public ResponseEntity<Category>  getCategoryByName(@PathVariable("name") String name) throws CategoryException{
    	   Category c= categoryService.getCategorybyName(name);
    	   return ResponseEntity.ok(c);
       }
}
