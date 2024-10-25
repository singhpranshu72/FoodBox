package com.ruby.OnlineFoodApp.service;


import com.ruby.OnlineFoodApp.entity.Cart;
import com.ruby.OnlineFoodApp.exceptions.CartException;
import com.ruby.OnlineFoodApp.exceptions.ItemException;

public interface FoodCartService {
	
	public Cart saveCart(Cart cart)throws CartException;
	
	public Cart addItem(Integer cartId, Integer itemId)throws CartException,ItemException;
	
	public Cart clearCart(Integer cartId)throws CartException;
	
	public Cart viewCart(Integer cartId)throws CartException;

}
