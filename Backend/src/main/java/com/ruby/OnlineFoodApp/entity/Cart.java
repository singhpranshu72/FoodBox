package com.ruby.OnlineFoodApp.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cartId")
public class Cart {
	@Id
	@NotNull(message = "The cart's Id is required.")
	private Integer cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	
	@OneToMany(mappedBy = "cart",targetEntity = Food.class,cascade = CascadeType.ALL)
	private List<Food> food;


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(Integer cartId, Customer customer, List<Food> food) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.food = food;
	}


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Food> getFood() {
		return food;
	}


	public void setFood(List<Food> food) {
		this.food = food;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", food=" + food + "]";
	}

}
