package com.brandon.BasicWebApp2.model;

import java.util.List;

public class Account {
	
	private String username;
	private String password;
	private List<Order> transactionHistory;
	private Name name;
	private Address address;
	private CreditCard creditCard;
	private Restaurant restaurant; // if is a storeOwner, this is their restaurant
	
	// Ability Modifiers
	private boolean admin; // has admin privileges or not
	private boolean restaurantOwner; // owns a restaurant or not
	
	public Account(String userName, String password, Name name, Address address) {
		this.username = userName;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	
	// Getters and Setters
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<Order> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isRestaurantOwner() {
		return restaurantOwner;
	}

	public void setRestaurantOwner(boolean restaurantOwner) {
		this.restaurantOwner = restaurantOwner;
	}

	
	
	
	
	
}
