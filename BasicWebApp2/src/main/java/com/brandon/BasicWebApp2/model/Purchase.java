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
	private double subTotal;
	private boolean canceled;
	
	public Purchase() {} // default
	
	public Purchase(int orderID, int storeID, String userID, double total) {
		this.purchaseID = orderID;
		this.storeID = storeID;
		this.userID = userID;
		this.canceled = false;
		this.total = total;
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
	

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + purchaseID + " total="+total + " userID=" + userID + "]";
	}
	
	
	

}
