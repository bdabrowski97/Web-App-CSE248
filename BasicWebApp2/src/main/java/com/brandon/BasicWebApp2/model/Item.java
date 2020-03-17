package com.brandon.BasicWebApp2.model;

import java.awt.Image;

/**
 * Menu item in a store
 * @author bdabr
 *
 */
public class Item {
	private String name;
	private String description;
	private double price;
	private Image photo;
	
	/**
	 * Version of item if no image is available
	 * @param name Name of item
	 * @param dec Description of item
	 * @param price Price of item
	 */
	public Item(String name, String dec, double price) {
		this.name = name;
		this.description = dec;
		this.price = price;
		this.photo = null;
	}
	 /**
	  * Item available for purchase on menu
	  * @param name Name of item
	  * @param dec Item description
	  * @param price Item price
	  * @param img Image of item
	  */
	public Item(String name, String dec, double price, Image img) {
		this.name = name;
		this.description = dec;
		this.price = price;
		this.photo = img;
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
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
	public Image getPhoto() {
		return photo;
	}
	public void setPhoto(Image photo) {
		this.photo = photo;
	}
	
	
	
}
