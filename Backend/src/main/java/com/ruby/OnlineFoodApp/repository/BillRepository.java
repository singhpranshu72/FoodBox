package com.ruby.OnlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruby.OnlineFoodApp.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

}
