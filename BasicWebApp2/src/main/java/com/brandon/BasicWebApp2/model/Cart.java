package com.brandon.BasicWebApp2.model;

import java.io.Serializable;
import java.util.TreeMap;


/**
 * This holds items that a user wants to buy
 * @author bdabr
 *
 */
public class Cart implements Serializable{
	// private static final long serialVersionUID = -5266471585635469192L;
	private TreeMap<Integer, Item> itemsInCart;
	private double subtotal;
	private double total;
	
	/**
	 * Holds all items that are being considered for purchase
	 */
	public Cart() {
		itemsInCart = new TreeMap<>();
		subtotal = 0;
		total = 0;
	}

	// Getters and Setters
	
	public TreeMap<Integer, Item> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(TreeMap<Integer, Item> itemsInCart) {
		this.itemsInCart = itemsInCart;
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

	
	
	
	
	
	
	
}