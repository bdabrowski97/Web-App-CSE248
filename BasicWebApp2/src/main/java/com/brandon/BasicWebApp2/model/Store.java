package com.brandon.BasicWebApp2.model;

import java.util.List;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A store owner by a StoreOwner. Has products that can be bought by users.
 * @author bdabr
 *
 */
@Entity
public class Store {

	private String owner;
	private String tags;
	private String name;
	private boolean open;
	@Id
	private int storeID;
	
	public Store() {} // default
	
	/**
	 * Basic store information
	 * @param owner StoreOwner account thats in charge of store
	 * @param name Name of the Store
	 * @param id Id number used for store in case theres duplicate names
	 */
	public Store(String owner, String name, int id) {
		this.owner = owner;
		this.name = name;
		open = false;
		this.storeID = id;
	}



	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

//	public void setMenu(List<Item> menu) {
//		this.menu = menu;
//	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
}
