package com.brandon.BasicWebApp2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	private int purchaseID; // all items bought are tagged with this orderID
	private int storeID; // store the order was placed at
	private String storeName;
	private String userID; // all items belong to this username
	private double total;
	
	public Purchase() {} // default
	
	public Purchase(int orderID, int storeID, String userID, double total) {
		this.purchaseID = orderID;
		this.storeID = storeID;
		this.userID = userID;
	
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + purchaseID + " total="+total + " userID=" + userID + "]";
	}
	
	
	

}
