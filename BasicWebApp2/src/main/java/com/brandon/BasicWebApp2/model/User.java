package com.brandon.BasicWebApp2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Account type that purchases food from stores
 * @author bdabr
 *
 */
public class User extends Account {
	
	private CreditCard card;
	private TreeSet<Order> orderHistory;
	private Cart cart;
	
	/**
	 * User information
	 * @param username Screen name
	 * @param password password
	 * @param name Full Name
	 * @param address Home Address
	 * @param card Credit card used for purchases
	 */
	public User(String username, String password, Name name, Address address, CreditCard card) {
		super(username, password, name, address);
		this.card = card;
		orderHistory = new TreeSet<>();
		cart = new Cart();
	}
	
	
	
	
	

}
