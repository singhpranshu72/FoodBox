package com.ruby.OnlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ruby.OnlineFoodApp.entity.Category;
import com.ruby.OnlineFoodApp.entity.Customer;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT COALESCE(MAX(e.categoryId),0) FROM Category e")
	public Integer findMaxCategoryId();
	
	@Query("select e from Category e where e.categoryName like %:categoryName%")
	public Category findbyName( @Param("categoryName") String categoryName);
}
