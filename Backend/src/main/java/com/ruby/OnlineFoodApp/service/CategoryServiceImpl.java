package com.ruby.OnlineFoodApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Category;
import com.ruby.OnlineFoodApp.exceptions.CategoryException;
import com.ruby.OnlineFoodApp.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

	
	
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryRepository.findById(category.getCategoryId());
		if(opt.isPresent()) {
			throw new CategoryException("Category already exists..");
		}else {
			return categoryRepository.save(category);
		}
	}



	@Override
	public Category updateCategory(Category category) throws CategoryException {
		Optional<Category> opt = categoryRepository.findById(category.getCategoryId());
		if(opt.isPresent()) {
			return categoryRepository.save(category);
		}else {
			throw new CategoryException("No such Category found..");
		}
	}



	@Override
	public Category viewCategory(Integer categoryId) throws CategoryException {
		Optional<Category> opt = categoryRepository.findById(categoryId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}



	@Override
	public Category removeCategory(Integer categoryId) throws CategoryException {
		Optional<Category> opt = categoryRepository.findById(categoryId);
		if(opt.isPresent()) {
			Category cat = opt.get();
			categoryRepository.delete(cat);
			return cat;
		}else {
			throw new CategoryException("No Category found with ID: "+categoryId);
		}
	}



	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		List<Category> categories = categoryRepository.findAll();
		if(categories.size() > 0) {
			return categories;
		}else {
			throw new CategoryException("No Categories exists..");
		}
	}



	@Override
	public Integer findNextCategoryId() throws CategoryException {
		return categoryRepository.findMaxCategoryId();
	}



	@Override
	public Category getCategorybyName(String name) throws CategoryException {
		// TODO Auto-generated method stub
		return categoryRepository.findbyName(name)	;}
	
	
	

}
