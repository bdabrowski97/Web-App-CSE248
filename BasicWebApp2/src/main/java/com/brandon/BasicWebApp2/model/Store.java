package com.brandon.BasicWebApp2.model;

import java.util.List;
import java.util.TreeSet;

/**
 * A store owner by a StoreOwner. Has products that can be bought by users.
 * @author bdabr
 *
 */
public class Store {
	private List<Item> menu;
	private TreeSet<Item> transactionHistory;
	private Account owner;
	private String[] tags;
	private String name;
	private boolean open;
	private int id;
	
	/**
	 * Basic store information
	 * @param owner StoreOwner account thats in charge of store
	 * @param name Name of the Store
	 * @param id Id number used for store in case theres duplicate names
	 */
	public Store(Account owner, String name, int id) {
		this.owner = owner;
		this.name = name;
		transactionHistory = new TreeSet<>();
		open = false;
		this.id = id;
	}

	// Getters and Setters
	public List<Item> getMenu() {
		return menu;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

	public TreeSet<Item> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(TreeSet<Item> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
