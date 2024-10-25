package com.ruby.OnlineFoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Customer;
import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.entity.OrderDetails;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;
import com.ruby.OnlineFoodApp.exceptions.OrderException;
import com.ruby.OnlineFoodApp.repository.CustomerRepository;
import com.ruby.OnlineFoodApp.repository.OrderRepository;


@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(order.getOrderId());
		if(opt.isPresent()) {
			throw new OrderException("Order already exists..");
		}else {
			return orderRepository.save(order);
		}
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(order.getOrderId());
		if(opt.isPresent()) {
			return orderRepository.save(order);
		}else {
			throw new OrderException("Order such Order exists..");
		}
	}

	@Override
	public OrderDetails removeOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			orderRepository.delete(order);
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}

	@Override
	public OrderDetails viewOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> opt = orderRepository.findById(orderId);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}

	@Override
	public List<Food> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException {
		Optional<Customer> cOpt =customerRepository.findById(customerId);
		if(cOpt.isPresent()) {
			Customer customer = cOpt.get();
			 List<Food> itemList = customer.getCart().getFood();
			 if(itemList.size() > 0) {
				 return itemList;
			 }else {
				 throw new OrderException("No Orders found..");
			 }
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

	
	
}
