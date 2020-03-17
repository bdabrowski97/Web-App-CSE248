package com.brandon.BasicWebApp2.model;

import java.util.Date;

import java.util.List;
import java.util.TreeSet;

/**
 * Record of order made, is saved both in the user's data and the store's data
 * @author bdabr
 *
 */
public class Order {
	private TreeSet<Item> itemsBought;
	private User owner; // account that made the account
	private Store store; // restaurant order was made from
	private double subtotal;
	private double total;
	private Date date;
	
	/**
	 * Holds all information for a made order
	 * @param owner User who made the purchase
	 * @param store Store the order was made at
	 * @param subtotal price before tax
	 * @param total price after tax
	 */
	public Order(User owner, Store store, double subtotal, double total) {
		itemsBought = new TreeSet<Item>();
		this.owner = owner;
		this.store = store;
		this.subtotal = subtotal;
		this.total = total;
		date = new Date();
	}

	// Getters and setters
	
	public TreeSet<Item> getItemsBought() {
		return itemsBought;
	}
	public void setItemsBought(TreeSet<Item> itemsBought) {
		this.itemsBought = itemsBought;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
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
