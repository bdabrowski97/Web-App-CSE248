package com.brandon.BasicWebApp2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	private int purchaseID; // all items bought are tagged with this orderID
	private int storeID; // store the order was placed at
	private String userID; // all items belong to this username
	private double subtotal;
	private double total;
	
	public Purchase() {} // default
	
	public Purchase(int orderID, int storeID, String userID, double subtotal, double total) {
		this.purchaseID = orderID;
		this.storeID = storeID;
		this.userID = userID;
		this.subtotal = subtotal;
		this.total = total;
	}

	public int getOrderID() {
		return purchaseID;
	}

	public void setOrderID(int orderID) {
		this.purchaseID = orderID;
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
		return "Order [orderID=" + purchaseID + " total="+total + " userID=" + userID + "]";
	}
	
	
	

}
