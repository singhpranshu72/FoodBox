package com.ruby.OnlineFoodApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.OnlineFoodApp.entity.Bill;
import com.ruby.OnlineFoodApp.entity.Customer;
import com.ruby.OnlineFoodApp.entity.Food;
import com.ruby.OnlineFoodApp.repository.BillRepository;
import com.ruby.OnlineFoodApp.repository.CustomerRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	
	
	@Override
	public Bill addBill(Bill bill)  {
		Optional<Bill> opt = billRepository.findById(bill.getBillId());
		if(opt !=null) {
			System.out.println("User already exist");
			
		}
			return billRepository.save(bill);
	
	}


	@Override
	public Bill updateBill(Bill bill)  {
//		Optional<Bill> opt = billRepository.findById(bill.getBillId());
//		if(opt.isPresent()) {
			return billRepository.save(bill);
		
	}


	@Override
	public Bill removeBill(Integer billId) {
		Optional<Bill> opt = billRepository.findById(billId);
//		if(opt.isPresent()) {
//		
//		}	
		Bill bill = opt.get();
			billRepository.delete(bill);
			return bill;
	}


	@Override
	public Bill viewBill(Integer billId)  {
		Optional<Bill> opt = billRepository.findById(billId);
		return opt.get();
	}


	@Override
	public String generateTotalBillById(Integer customerId)  {
		Optional<Customer> cOpt = customerRepository.findById(customerId);
			Customer customer = cOpt.get();
			List<Food> items = customer.getCart().getFood();
			
			if(items.size() > 0) {
				
				Double total = 0.0;
				for(Food item : items) {
					total += (item.getPrice()*item.getQuantity()); 
				}
				
				return "The total bill for "+customer.getFullName()+" is "+total;
				
			}
			return "";
		
	}

	
	
	
	
}
