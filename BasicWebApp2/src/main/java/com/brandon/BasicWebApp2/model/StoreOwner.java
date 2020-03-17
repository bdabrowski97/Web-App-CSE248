package com.brandon.BasicWebApp2.model;

/**
 * Account type that manages a store
 * @author bdabr
 *
 */
public class StoreOwner extends Account {

	private Store store;
	
	/**
	 * Information about the store owner
	 * @param username Screen name
	 * @param password password
	 * @param name Full Name
	 * @param address Store Address
	 * @param store Store data
	 */
	public StoreOwner(String username, String password, Name name, Address address, Store store) {
		super(username, password, name, address);
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	

}
