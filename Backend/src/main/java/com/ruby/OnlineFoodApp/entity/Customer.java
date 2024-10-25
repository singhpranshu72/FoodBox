package com.ruby.OnlineFoodApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	
	@Size(min = 3, max = 30, message = "Name must be between 3 and 30 character")
	@Pattern(regexp = "[^0-9]*", message = "Name must not contain numbers")
	@NotBlank(message = "Name is mandatory")
	private String fullName;
	
	@Pattern(regexp = "Admin|Customer", message = "Role must be Admin or Customer")
	@NotBlank(message = "Role is a mandatory")
	private String role;
	
	@NotBlank(message = "Gender is a mandatory")
	private String gender;
	
	@NotBlank(message = "Contact Number is mandatory")
    @Pattern(regexp = "^(\\+91|91)?[789]\\d{9}$", message = "Mobile number must be 10 digits starting with 7, 8, or 9, and may start with +91 or 91")
	private String mobileNumber;
	
	
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is a mandatory")
	private String email;
	
	
	@Size(min = 8, message = "Password must be at least 8 characters")
    @NotBlank(message = "Password is a mandatory")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$", 
             message = "Password must contain at least one uppercase letter, one number, and one special character")
	private String password;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer customerId, String fullName, String role, String gender, String mobileNumber, String email,
			String password, Address address, Cart cart) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.role = role;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = cart;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", role=" + role + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password + ", address="
				+ address + ", cart=" + cart + "]";
	}


	
}
