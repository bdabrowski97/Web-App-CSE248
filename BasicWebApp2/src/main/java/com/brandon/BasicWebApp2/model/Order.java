package com.brandon.BasicWebApp2.model;


import java.io.Serializable;
import java.util.Date;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A copy of any items bought, this is stored in the StoreDataBase as records of who bought what items
 * @author bdabr
 *
 */
@Entity
public class Order implements Comparable<Order>, Serializable {
//	private static final long serialVersionUID = -1423574175558137158L;
	
	@Id
	private int orderID;
	private TreeSet<Item> itemsbought;
	private Date orderDate;
	private double total;
	private double subTotal;
	private String owner;
	private int storeID;
	
	
	public Order( ){} // defualt
	
	/**
	 * Contains all information for a placed order
	 * @param total Total sale price after tax
	 * @param subTotal Sale price before tax
	 * @param owner The account that placed the order
	 */
	public Order( double total, double subTotal, String owner) {
		itemsbought = new TreeSet<>();
		this.orderDate = new Date();
		this.total = total;
		this.subTotal = subTotal;
		this.owner = owner;
		this.orderID = 0;
	}
	
	/**
	 * Adds item to Order receipt
	 * @param itemToAdd Item being added to receipt
	 */
	public void addItemToOrder(Item itemToAdd) {
		itemsbought.add(itemToAdd);
	}
	
	/**
	 * Removes item from Order receipt
	 * @param itemToRemove item being removed
	 */
	public void removeItemFromOrder(Item itemToRemove) {
		itemsbought.remove(itemToRemove);
	}
	
	
	
	// setters and getters
	
	public TreeSet<Item> getItemsbought() {
		return itemsbought;
	}

	public void setItemsbought(TreeSet<Item> itemsbought) {
		this.itemsbought = itemsbought;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return orderID + " " + orderDate + " " + total + " " + subTotal + " " + owner;
	}
	
	@Override
	public int compareTo(Order other) {
		if (this.orderID > other.orderID) {
			return 1;
		}
		if (this.orderID < other.orderID) {
			return -1;
		}
		return 0;
	}
	
	
	
}