package com.brandon.BasicWebApp2.model;
/**
 * Stores account's actual name
 * @author bdabr
 *
 */
public class Name {
	
	private String first;
	private String last;
	
	/**
	 * Real name
	 * @param first first name
	 * @param last last name
	 */
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	// Getters and Setters
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	
	
}
