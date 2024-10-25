package com.ruby.OnlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ruby.OnlineFoodApp.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{
	
}
