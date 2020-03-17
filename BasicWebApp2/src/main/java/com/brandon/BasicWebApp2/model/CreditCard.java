package com.brandon.BasicWebApp2.model;

/**
 *  This class holds the credit card information for a user
 * @author bdabr
 *
 */
public class CreditCard {
	
	private String num;
	private String cvc;
	private String expirationDate;
	
	/**
	 * User's credit card info
	 * @param num Card number
	 * @param cvc Security Code
	 * @param expirationDate Experiation Date
	 */
	public CreditCard(String num, String cvc, String expirationDate) {
		this.num = num;
		this.cvc = cvc;
		this.expirationDate = expirationDate;
	}

	// Getters and Setters
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
