package com.brandon.BasicWebApp2.model;

/**
 * Used to process payments with credit card
 * @author bdabr
 *
 */
public class PaymentInfo {
	
	private String mainNum;
	private String securityCode;
	private String experationDate;
	
	public PaymentInfo() {} // default
	
	/**
	 * Credit card info
	 * @param num Credit card number
	 * @param cvc credit card secruity code
	 * @param expDate credit card experation date
	 */
	public PaymentInfo(String num, String cvc, String expDate) {
		mainNum = num;
		securityCode = cvc;
		experationDate = expDate;
	}
	
	/**
	 * Checks if the credit info is legitament (number is 16 digits long, cvc is 3 digits long, expDate is 4 digits long
	 * @return
	 */
	public boolean paymentValid() {
		if (mainNum.length() != 16 || securityCode.length() != 3 || experationDate.length() != 4) {
			return false;
		} else {
			return true;
		}
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
	

	/**
	 * Provides a string of the credit card info. Alters whats shown based on how if the data entered is correct or not. Adds ** for privacy concerns
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (mainNum.length() > 4) {
			for (int i = 0; i < 4; i++) {
				sb.append(mainNum.charAt(i));
			}
			sb.append("************");
			String num = sb.toString();
			return num + " *** expires: " +  experationDate;
		} else {
			if (mainNum.equals("no")) {
				return mainNum + " " + securityCode + " " + experationDate;
			} else {
				return mainNum + " *** expires: " + experationDate;
			}
			
		}
	}
	

}
