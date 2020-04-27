package com.brandon.BasicWebApp2.model;

import java.awt.Image;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Menu item in a store
 * @author bdabr
 *
 */
@Entity
public class ItemBought {
	private String name;
	private String description;
	private double price;
	@Id
	private int purchaseID; // ties this item to the purchase it was placed in
	
	
	public ItemBought() {} // default
	
	/**
	 * Version of item if no image is available
	 * @param name Name of item
	 * @param dec Description of item
	 * @param price Price of item
	 */
	public ItemBought(String name, String dec, double price) {
		this.name = name;
		this.description = dec;
		this.price = price;
		this.purchaseID = purchaseID;
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
	
	
	
}