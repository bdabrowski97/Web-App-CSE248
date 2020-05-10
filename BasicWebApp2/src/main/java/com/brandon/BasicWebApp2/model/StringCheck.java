package com.brandon.BasicWebApp2.model;

/**
 * Tool used to help cut down on typed code in controller methodds
 * @author bdabr
 *
 */
public class StringCheck {
	/**
	 * Used to check is a string is either null or ""
	 * @param string
	 * @return
	 */
	public static boolean checkNullOrEmpty(String string) {
		if (string.equals("") || string.equals(null)) {
			return true;
		}
		
		return false;
		
		// returns true if string is empty or null
	}
}
