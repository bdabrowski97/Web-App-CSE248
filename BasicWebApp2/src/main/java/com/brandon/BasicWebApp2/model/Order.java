package com.brandon.BasicWebApp2.model;

import java.util.Date;
import java.util.List;

public class Order {
	private List<Item> itemsBought;
	private Account owner; // account that made the account
	private Restaurant restaurant; // restaurant order was made from
	private double subtotal;
	private double total;
	private Date date;
	
	// Getters and Setters
	
	public List<Item> getItemsBought() {
		return itemsBought;
	}
	public void setItemsBought(List<Item> itemsBought) {
		this.itemsBought = itemsBought;
	}
	public Account getOwner() {
		return owner;
	}
	public void setOwner(Account owner) {
		this.owner = owner;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
