package com.brandon.BasicWebApp2.model;

public class PaymentInfo {
	
	private String mainNum;
	private String securityCode;
	private String experationDate;
	
	public PaymentInfo() {} // default
	
	public PaymentInfo(String num, String cvc, String expDate) {
		mainNum = num;
		securityCode = cvc;
		experationDate = expDate;
	}

	
	// getters and setters
	
	public String getMainNum() {
		return mainNum;
	}

	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExperationDate() {
		return experationDate;
	}

	public void setExperationDate(String experationDate) {
		this.experationDate = experationDate;
	}
	
	@Override
	public String toString() {
		return mainNum + " " + securityCode + " " + experationDate;
		
	}
	

}
