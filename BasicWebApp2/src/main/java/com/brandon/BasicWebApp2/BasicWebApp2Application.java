package com.brandon.BasicWebApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicWebApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(BasicWebApp2Application.class, args);
	}
	
	/*
	 * LIST OF IDS WE USE IN THE SESSIONS
	 * 
	 * -storedUsername — user that is currently logged in 
	 * - if Store is not created, storeID == 0
	 *  - storedStoreID — user that currently logged in storeID
	 *  - storedStoreName — name of the store thats logged in
	 * 
	 * 
	 * 
	 */

}
