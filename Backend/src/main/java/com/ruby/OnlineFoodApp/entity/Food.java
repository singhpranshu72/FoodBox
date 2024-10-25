package com.ruby.OnlineFoodApp.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Food {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer foodId;
	
	@NotBlank(message = "Food Name is mandatory")
	private String foodName;
	
	
	@NotNull(message = "The orderdQuantity is required.")
	private Integer orderdQuantity;
	
	@NotNull(message = "The quantity is required.")
	private Integer quantity;
	
	@NotNull(message = "The price is required.")
	private Integer price;
	
	private Boolean isDisable;
    private String description;
    private String url;
    
    
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Category category;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "cartId")
	private Cart cart;

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(Integer foodId, String foodName, Integer orderdQuantity, Integer quantity, Integer price,
			Boolean isDisable, String description, String url, Category category, Cart cart) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.orderdQuantity = orderdQuantity;
		this.quantity = quantity;
		this.price = price;
		this.isDisable = isDisable;
		this.description = description;
		this.url = url;
		this.category = category;
		this.cart = cart;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getOrderdQuantity() {
		return orderdQuantity;
	}

	public void setOrderdQuantity(Integer orderdQuantity) {
		this.orderdQuantity = orderdQuantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Boolean isDisable) {
		this.isDisable = isDisable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", orderdQuantity=" + orderdQuantity
				+ ", quantity=" + quantity + ", price=" + price + ", isDisable=" + isDisable + ", description="
				+ description + ", url=" + url + ", category=" + category + ", cart=" + cart + "]";
	}

	
}
