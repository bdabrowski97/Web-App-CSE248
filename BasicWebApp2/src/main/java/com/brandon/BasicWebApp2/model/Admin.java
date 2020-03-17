package com.brandon.BasicWebApp2.model;

/**
 * Account type that has special access to stores/user information
 * @author bdabr
 *
 */
public class Admin extends Account {

	public Admin(String username, String password, Name name, Address address) {
		super(username, password, name, address);
	}

}
