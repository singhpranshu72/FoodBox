package com.ruby.OnlineFoodApp.service;

import java.util.List;

import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.exceptions.ItemException;


public interface ItemService {
	
	public Food addItem(Food item)throws ItemException;
	
	public Food updateItem(Food item)throws ItemException;
	
	public Food viewItem(Integer itemId)throws ItemException;
	
	public Food removeItem(Integer itemId)throws ItemException;
	
	public List<Food> viewAllItems()throws ItemException;

}
