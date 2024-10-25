package com.ruby.OnlineFoodApp.service;

import java.util.List;

import com.ruby.OnlineFoodApp.entity.Category;
import com.ruby.OnlineFoodApp.exceptions.CategoryException;


public interface CategoryService {
	
	
	public Category addCategory(Category category)throws CategoryException;
	
	public Category updateCategory(Category category)throws CategoryException;
	
	public Category viewCategory(Integer categoryId)throws CategoryException;
	
	public Category removeCategory(Integer categoryId)throws CategoryException;
	
	public List<Category> viewAllCategory()throws CategoryException;
	
	public Integer findNextCategoryId()throws CategoryException;
	
	public Category getCategorybyName(String name)throws CategoryException;


}
