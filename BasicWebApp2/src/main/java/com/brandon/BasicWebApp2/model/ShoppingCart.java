package com.brandon.BasicWebApp2.model;

import java.util.ArrayList;

/**
 * Used to keep track of items a user wants to buy. Is temporary and not stored in the database
 * @author bdabr
 *
 */
public class ShoppingCart {
	
	private double price;
	private double subtotal;
	private ArrayList<Item> items;
	
	/**
	 * Constructor for shopping cart
	 */
	public ShoppingCart() {
		this.price = 0;
		this.subtotal = 0;
		items = new ArrayList<>();
	}
	
	/**
	 * Calculates price with tax included
	 */
	public void calculatePrice() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getPrice();
		}
		double tax = total * .0882;
		total += tax;
		total = Math.floor(total * 100) / 100;
		setPrice(total);
	}
	
	/**
	 * Calculates price without tax
	 */
	public void calculateSubtotal() {
		double sub = 0;
		for (int i = 0; i < items.size(); i++) {
			sub += items.get(i).getPrice();
		}
		sub = Math.floor(sub * 100) / 100;
		setSubtotal(sub);
	}
	
	/**
	 * Empties the shopping cart
	 */
	public void clearItems() {
		items.clear();
	}
	
	/**
	 * Adds item to the shopping cart
	 * @param item Item being added
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	

}
