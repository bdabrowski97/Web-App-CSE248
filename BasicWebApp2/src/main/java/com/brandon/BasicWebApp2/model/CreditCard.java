package com.brandon.BasicWebApp2.model;

public class CreditCard {
	
	private String num;
	private String cvc;
	private String expirationDate;
	
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
