package com.brandon.BasicWebApp2.model;

public class StringCheck {
	public static boolean checkNullOrEmpty(String string) {
		if (string.equals("") || string.equals(null)) {
			return true;
		}
		
		return false;
		
		// returns true if string is empty or null
	}
}
