package com.brandon.BasicWebApp2.model;

import java.util.ArrayList;

public class ShoppingCart {
	
	private double price;
	private double subtotal;
	private ArrayList<Item> items;
	
	
	public ShoppingCart() {
		this.price = 0;
		this.subtotal = 0;
		items = new ArrayList<>();
	}
	
	public void calculatePrice() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getPrice();
		}
		double tax = total * .0882;
		total += tax;
		total = Math.floor(total * 100) / 100;
		setPrice(total);
	}
	
	public void calculateSubtotal() {
		double sub = 0;
		for (int i = 0; i < items.size(); i++) {
			sub += items.get(i).getPrice();
		}
		setSubtotal(sub);
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	

}
