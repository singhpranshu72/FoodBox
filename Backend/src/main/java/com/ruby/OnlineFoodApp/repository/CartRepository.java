package com.ruby.OnlineFoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruby.OnlineFoodApp.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
