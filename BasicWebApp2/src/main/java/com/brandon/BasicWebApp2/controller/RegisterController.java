package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brandon.BasicWebApp2.dao.AccountRepo;
import com.brandon.BasicWebApp2.dao.ItemBoughtRepo;
import com.brandon.BasicWebApp2.dao.PurchaseRepo;
import com.brandon.BasicWebApp2.dao.StoreRepo;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class RegisterController {
	

	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/register") // choose which account type you want
	public String register(HttpServletRequest request) {
	/*	HttpSession session = request.getSession();
		System.out.println(session.getAttribute("storedUsername").toString());
		*/
		return "pages/register/register.jsp";
	}
	
	@RequestMapping("/registerUser") // user create form
	public String registerUser() {
		return "pages/register/registerUser.jsp";
	}
	
	@RequestMapping("/addUser") // function that creates the user
	public String addUser(HttpServletRequest request, Model model) {
		String enteredUsername = request.getParameter("username"); // gets the value from the text box in the jsp
		String enteredPassword = request.getParameter("password");
		String enteredFirst = request.getParameter("firstname");
		String enteredLast = request.getParameter("lastname");
		String enteredStreet = request.getParameter("street");
		String enteredCity = request.getParameter("city");
		String enteredState = request.getParameter("state");
		String enteredZip = request.getParameter("zipcode");
		String enteredCountry = request.getParameter("country");
		model.addAttribute("username", enteredUsername); // sends this info to next page
		
		enteredUsername = enteredUsername.trim();
		enteredPassword = enteredPassword.trim();
		enteredFirst = enteredFirst.trim();
		enteredLast = enteredLast.trim();
		enteredStreet = enteredStreet.trim();
		enteredCity = enteredCity.trim();
		enteredState = enteredState.trim();
		enteredZip = enteredZip.trim();
		enteredCountry = enteredCountry.trim();
		
		if (enteredUsername.equals("ADMIN_CREATION") && enteredPassword.equals("ADMIN_CREATION")) { // code to create admin
			return "pages/register/registerAdmin.jsp";
		}
		
		if (StringCheck.checkNullOrEmpty(enteredUsername) == true || StringCheck.checkNullOrEmpty(enteredPassword) == true || 
				StringCheck.checkNullOrEmpty(enteredFirst) == true || StringCheck.checkNullOrEmpty(enteredLast) == true ||
				StringCheck.checkNullOrEmpty(enteredStreet) == true || StringCheck.checkNullOrEmpty(enteredCity) == true ||
				StringCheck.checkNullOrEmpty(enteredState) == true || StringCheck.checkNullOrEmpty(enteredZip) == true ||
				StringCheck.checkNullOrEmpty(enteredCountry) == true) {
			return "pages/register/registerUserInvalid.jsp";
		} 
		
		if (aRepo.existsById(enteredUsername) == true) { // if user already exists
			return "pages/register/registerUserInvalid.jsp";
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(false);
			acc.setStoreOwner(false);	
			CreditCard cc = new CreditCard();
			acc.setCard(cc);
			aRepo.save(acc);
			return "pages/register/madeUser.jsp";
		}
		
	}
	
	@RequestMapping("/registerOwner") // owner creation form
	public String registerOwner() {
		return "pages/register/registerOwner.jsp";
	}
	
	@RequestMapping("/addStoreOwner") // function that creates the owner
	public String addStoreOwner(HttpServletRequest request, Model model) {
		String enteredUsername = request.getParameter("username"); // gets the value from the text box in the jsp
		String enteredPassword = request.getParameter("password");
		String enteredFirst = request.getParameter("firstname");
		String enteredLast = request.getParameter("lastname");
		String enteredStreet = request.getParameter("street");
		String enteredCity = request.getParameter("city");
		String enteredState = request.getParameter("state");
		String enteredZip = request.getParameter("zipcode");
		String enteredCountry = request.getParameter("country");
		model.addAttribute("username", enteredUsername);
		
		if (enteredUsername.equals("ADMIN_CREATION") && enteredPassword.equals("ADMIN_CREATION")) {
			return "pages/register/registerAdmin.jsp";
		}
		
		if (StringCheck.checkNullOrEmpty(enteredUsername) == true || StringCheck.checkNullOrEmpty(enteredPassword) == true || 
				StringCheck.checkNullOrEmpty(enteredFirst) == true || StringCheck.checkNullOrEmpty(enteredLast) == true ||
				StringCheck.checkNullOrEmpty(enteredStreet) == true || StringCheck.checkNullOrEmpty(enteredCity) == true ||
				StringCheck.checkNullOrEmpty(enteredState) == true || StringCheck.checkNullOrEmpty(enteredZip) == true ||
				StringCheck.checkNullOrEmpty(enteredCountry) == true) {
			return "pages/register/registerOwnerInvalid.jsp";
		} 
		
		if (aRepo.existsById(enteredUsername) == true) { // if user already exists
			return "pages/register/registerUserInvalid.jsp";
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(false);
			acc.setStoreOwner(true);
			
			aRepo.save(acc);
			return "pages/register/madeOwner.jsp";
		}
	}
	
	@RequestMapping("/registerAdmin") // admin creation form
	public String registerAdmin() {
		return "pages/register/registerAdmin.jsp";
	}
	
	@RequestMapping("/addAdmin") // function thats creates the admin
	public String addAdmin(HttpServletRequest request, Model model) {
		String enteredUsername = request.getParameter("username"); // gets the value from the text box in the jsp
		String enteredPassword = request.getParameter("password");
		String enteredFirst = request.getParameter("firstname");
		String enteredLast = request.getParameter("lastname");
		String enteredStreet = request.getParameter("street");
		String enteredCity = request.getParameter("city");
		String enteredState = request.getParameter("state");
		String enteredZip = request.getParameter("zipcode");
		String enteredCountry = request.getParameter("country");
		model.addAttribute("username", enteredUsername); // used to display username on page after registration is complete
		
		if (enteredUsername.equals("ADMIN_CREATION") && enteredPassword.equals("ADMIN_CREATION")) {
			return "pages/register/registerAdmin.jsp";
		} 
		
		if (StringCheck.checkNullOrEmpty(enteredUsername) == true || StringCheck.checkNullOrEmpty(enteredPassword) == true || 
				StringCheck.checkNullOrEmpty(enteredFirst) == true || StringCheck.checkNullOrEmpty(enteredLast) == true ||
				StringCheck.checkNullOrEmpty(enteredStreet) == true || StringCheck.checkNullOrEmpty(enteredCity) == true ||
				StringCheck.checkNullOrEmpty(enteredState) == true || StringCheck.checkNullOrEmpty(enteredZip) == true ||
				StringCheck.checkNullOrEmpty(enteredCountry) == true) {
			return "pages/register/registerAdminInvalid.jsp";
		} 
		
		if (aRepo.existsById(enteredUsername) == true) { // if user already exists
			return "pages/register/registerUserInvalid.jsp";
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(true);
			acc.setStoreOwner(false);
			
			aRepo.save(acc);
			return "pages/register/madeAdmin.jsp";
		}
	}
	
	
	
	
	

}
