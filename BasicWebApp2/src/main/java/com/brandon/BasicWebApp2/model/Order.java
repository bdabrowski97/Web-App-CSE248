package com.brandon.BasicWebApp2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	private int orderID; // all items bought are tagged with this orderID
	
	private int storeID; // store the order was placed at
	private String userID; // all items belong to this username
	private double subtotal;
	private double total;
	
	public Order() {} // default
	
	public Order(int orderID, int storeID, String userID, double subtotal, double total) {
		this.orderID = orderID;
		this.storeID = storeID;
		this.userID = userID;
		this.subtotal = subtotal;
		this.total = total;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + " total="+total + " userID=" + userID + "]";
	}
	
	
	

}
