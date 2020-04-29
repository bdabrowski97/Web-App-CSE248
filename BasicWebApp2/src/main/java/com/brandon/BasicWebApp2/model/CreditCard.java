package com.brandon.BasicWebApp2.model;

public class CreditCard {
	
	private String num;
	private String cvc;
	private String expDate;
	
	public CreditCard() {} // default
	
	
	public CreditCard(String num, String cvc, String expDate) {
		this.num = num;
		this.cvc = cvc;
		this.expDate = expDate;
	}

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

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (num == null || cvc == null || expDate == null) {
			return "no payment information";
		}
		
		if (num.length() > 4) {
			for (int i = 0; i < 4; i++) {
				sb.append(num.charAt(i));
			}
			for (int i = 0; i<4;i++) {
				sb.append("*");
			}
			
		} else { // if weird small number
			return "**** Expires on " + expDate;
		}
		
		
		String smallNum = sb.toString();
		
		
		return smallNum + " Expires on " + expDate;
	}
	
	
	
}
