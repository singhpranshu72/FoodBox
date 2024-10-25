package com.ruby.OnlineFoodApp.service;

import com.ruby.OnlineFoodApp.entity.Bill;
import com.ruby.OnlineFoodApp.exceptions.BillException;

public interface BillService {
	
	public Bill addBill(Bill bill) ;
	
	public Bill updateBill(Bill bill) ;
	
	public Bill removeBill(Integer billId);
	
	public Bill viewBill(Integer billId);
	
	public String generateTotalBillById(Integer customerId);
	

}
