package com.brandon.BasicWebApp2.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * This is the basic skeleton of the three account types for this program.
 * @author bdabr
 *
 */
@Entity
public class Account {
	
	@Id
	private String username;
	private String password;
	@Embedded
	private Name name;
	@Embedded
	private Address address;
	
	public Account() {} //this default constructor is required for the program to work
	
	/**
	 * Basic account info 
	 * @param username Screen name
	 * @param password password
	 * @param name First and Last name
	 * @param address Home Address
	 */
	public Account(String username, String password, Name name, Address address) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	
	
	// getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
