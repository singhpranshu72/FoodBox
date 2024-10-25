package com.ruby.OnlineFoodApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Customer;
import com.ruby.OnlineFoodApp.exceptions.CustomerException;
import com.ruby.OnlineFoodApp.repository.CustomerRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer already exists..");
		}else {
			return customerRepository.save(customer);
		}
	}


	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return customerRepository.save(customer);
		}else {
			throw new CustomerException("No such customer exists..");
		}
	}


	@Override
	public Customer removeCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			customerRepository.delete(customer);
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customer getCustomerbyName(String name) throws CustomerException {
		return customerRepository.findbyName(name);
	}


	@Override
	public Customer getCustomerbyEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		return customerRepository.findbyEmail(email);
	}

}
