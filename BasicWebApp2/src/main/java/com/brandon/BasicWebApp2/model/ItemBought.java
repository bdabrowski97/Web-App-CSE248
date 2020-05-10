package com.brandon.BasicWebApp2.model;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Copy of an item that was bought in a purchase. Cannot be deleted from database. Helps track order information
 * @author bdabr
 *
 */
@Entity
public class ItemBought {
	private String name;
	private String description;
	private double price;
	@Id
	private int purchaseID; // keep these in database
	private int orderID; // ties it to the order it was placed in
	
	
	public ItemBought() {} // default
	
	/**
	 * Copy of an item bought in a purchase
	 * @param name Item name
	 * @param dec Item description
	 * @param price Item price
	 */
	public ItemBought(String name, String dec, double price) {
		this.name = name;
		this.description = dec;
		this.price = price;
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}
	public int getPurchaseID() {
		return purchaseID;
	}

	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	
}
