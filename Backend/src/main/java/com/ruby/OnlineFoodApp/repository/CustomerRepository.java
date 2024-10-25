package com.ruby.OnlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruby.OnlineFoodApp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select e from Customer e where e.fullName like %:fullName%")
	public Customer findbyName( @Param("fullName") String fullName);
	
	@Query("select e from Customer e where e.email like %:email%")
	public Customer findbyEmail( @Param("email") String email);
}
