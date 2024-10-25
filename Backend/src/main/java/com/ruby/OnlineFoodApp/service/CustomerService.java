package com.ruby.OnlineFoodApp.service;

import com.ruby.OnlineFoodApp.entity.Customer;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer removeCustomerById(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;
	public Customer getCustomerbyName(String name)throws CustomerException;
	public Customer getCustomerbyEmail(String email)throws CustomerException;
}
