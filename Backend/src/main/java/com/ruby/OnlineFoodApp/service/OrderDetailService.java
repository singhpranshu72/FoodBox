package com.ruby.OnlineFoodApp.service;

import java.util.List;

import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.entity.OrderDetails;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;
import com.ruby.OnlineFoodApp.exceptions.OrderException;


public interface OrderDetailService {
	
	public OrderDetails addOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails removeOrder(Integer orderId)throws OrderException;
	
	public OrderDetails viewOrder(Integer orderId)throws OrderException;
	
	public List<Food> viewAllOrdersByCustomer(Integer customerId)throws OrderException,CustomerException;

}
