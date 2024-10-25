package com.ruby.OnlineFoodApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Cart;
import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.exceptions.CartException;
import com.ruby.OnlineFoodApp.exceptions.ItemException;
import com.ruby.OnlineFoodApp.repository.CartRepository;
import com.ruby.OnlineFoodApp.repository.FoodRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class FoodCartServiceImpl implements FoodCartService{
  
	@Autowired
	  CartRepository   cartRepository ;
	
	@Autowired
	FoodRepository foodRepository;
	
	@Override
	public Cart saveCart(Cart cart) throws CartException {
//		Optional<Cart> opt = cartRepository.findById(cart.getCartId());
//		if(opt.isPresent()) {
//			throw new CartException("Cart already exists..");
//		}else {
//			 return cartRepository.save(cart);
//		}
		return cartRepository.save(cart);
	}

	@Override
	public Cart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<Cart> cOpt = cartRepository.findById(cartId);
		if(cOpt.isPresent()) {
			
			Optional<Food> iOpt = foodRepository.findById(itemId);
			if(iOpt.isPresent()) {
				
				Cart cart = cOpt.get();
				Food item = iOpt.get();
				List<Food> list = new ArrayList<>();
				list.addAll(cart.getFood());
				list.add(item);
				cart.setFood(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}
	

	@Override
	public Cart clearCart(Integer cartId) throws CartException {
		Optional<Cart> opt = cartRepository.findById(cartId);
		if(opt.isPresent()) {
			Cart cart = opt.get();
			cartRepository.delete(cart);
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}

	@Override
	public Cart viewCart(Integer cartId) throws CartException {
		Optional<Cart> opt = cartRepository.findById(cartId);
		if(opt.isPresent()) {
			Cart cart = opt.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}
	
	
	
	

}
