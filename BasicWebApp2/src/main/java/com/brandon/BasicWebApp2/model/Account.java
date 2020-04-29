package com.brandon.BasicWebApp2.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is the basic skeleton of the three account types for this program.
 * @author bdabr
 *
 */
@Entity
public class Account {
	
	@Id
	private String username;
	private String password;
	
	@Embedded
	private Name name;
	@Embedded
	private Address address;
	
	// if not a store owner or admin, use these properties as well
	@Embedded
	private PaymentInfo paymentInfo;
	// private TreeSet<Order> history;  //Orders will be in their own data table. 
										//They'll have both store references and user references to get all the data when needed for either the store or the user
	// store owner stuff
	private boolean isStoreOwner;
	private int storeID;
	
	// if is Admin, cannot own store or make purchases, nor enters a credit card
	private boolean isAdmin;
	
	
	public Account() {} //this default constructor is required for the program to work
	
	/**
	 * Basic account info 
	 * @param username Screen name
	 * @param password password
	 * @param name First and Last name
	 * @param address Home Address
	 */
	public Account(String username, String password, Name name, Address address) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		
	}

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

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}


	public boolean isStoreOwner() {
		return isStoreOwner;
	}

	public void setStoreOwner(boolean isStoreOwner) {
		this.isStoreOwner = isStoreOwner;
	}



	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return username + " " + "isStoreOwner:" + isStoreOwner;
	}
	
	
}
