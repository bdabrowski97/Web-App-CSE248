package com.brandon.BasicWebApp2.model;

import java.util.List;

public class Restaurant {
	private List<Item> menu;
	private List<Order> transactionHistory;
	private Account owner;
	private String[] tags;
	private String name;
	
	public Restaurant(Account owner, String name) {
		this.owner = owner;
		this.name = name;
	}

	// Getters and Setters
	
	public List<Item> getMenu() {
		return menu;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

	public List<Order> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(List<Order> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
