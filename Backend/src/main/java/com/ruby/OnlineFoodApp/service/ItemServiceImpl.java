package com.ruby.OnlineFoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.exceptions.ItemException;
import com.ruby.OnlineFoodApp.repository.FoodRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	FoodRepository foodRepository;

	@Override
	public Food addItem(Food item) throws com.ruby.OnlineFoodApp.exceptions.ItemException {
		Optional<Food> opt = foodRepository.findById(item.getFoodId());
		if(opt.isPresent()) {
			throw new ItemException("Item already exists..");
		}else {
			return foodRepository.save(item);
		}
	}

	@Override
	public Food updateItem(Food item) throws com.ruby.OnlineFoodApp.exceptions.ItemException {
		Optional<Food> opt = foodRepository.findById(item.getFoodId());
		if(opt.isPresent()) {
			return foodRepository.save(item);
		}else {
			throw new ItemException("No such Item found..");
		}
	}

	@Override
	public Food viewItem(Integer itemId) throws com.ruby.OnlineFoodApp.exceptions.ItemException {
		Optional<Food> opt = foodRepository.findById(itemId);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}

	@Override
	public Food removeItem(Integer itemId) throws com.ruby.OnlineFoodApp.exceptions.ItemException {
		Optional<Food> opt = foodRepository.findById(itemId);
		if(opt.isPresent()) {
			Food item = opt.get();
			foodRepository.delete(item);
			return item;
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}

	@Override
	public List<Food> viewAllItems() throws com.ruby.OnlineFoodApp.exceptions.ItemException {
		List<Food> items = foodRepository.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new ItemException("No Item exists..");
		}
	}

	
	
	

}
