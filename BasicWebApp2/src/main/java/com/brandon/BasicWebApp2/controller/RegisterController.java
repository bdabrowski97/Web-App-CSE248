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

/**
 * Controller that handles account registration
 * @author bdabr
 *
 */
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
	
	/**
	 * Page that lets you choose which type of account you'd like to create
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/register") // choose which account type you want
	public String register(HttpServletRequest request) {
	/*	HttpSession session = request.getSession();
		System.out.println(session.getAttribute("storedUsername").toString());
		*/
		return "pages/register/register.jsp";
	}
	
	/**
	 * Registtration form for user type accounts
	 * @return
	 */
	@RequestMapping("/registerUser") // user create form
	public String registerUser() {
		return "pages/register/registerUser.jsp";
	}
	
	/**
	 * Processes data from user registration form and creates an entry in the data base
	 * @param request Used to recieve data
	 * @param model used to display data
	 * @return
	 */
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
			PaymentInfo pi = new PaymentInfo("no","payment","method");
			acc.setPaymentInfo(pi);
			aRepo.save(acc);
			return "pages/register/madeAccount.jsp";
		}
		
	}
	
	/**
	 * Registration form for storeOwner type accounts
	 * @return
	 */
	@RequestMapping("/registerOwner") // owner creation form
	public String registerOwner() {
		return "pages/register/registerOwner.jsp";
	}
	
	/**
	 * Processes data from storeOwner registration form and creates entry in database
	 * @param request Used to recieve data
	 * @param model used to display data
	 * @return
	 */
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
			PaymentInfo pi = new PaymentInfo("no","payment","method");
			acc.setPaymentInfo(pi);
			
			aRepo.save(acc);
			return "pages/register/madeAccount.jsp";
		}
	}
	
	/**
	 * Admin registration form
	 * @return
	 */
	@RequestMapping("/registerAdmin") // admin creation form
	public String registerAdmin() {
		return "pages/register/registerAdmin.jsp";
	}
	
	/**
	 * Processes data from admin registration form and creates entry in database
	 * @param request Used to recieve data
	 * @param model used to display data
	 * @return
	 */
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
			PaymentInfo pi = new PaymentInfo("no","payment","method");
			acc.setPaymentInfo(pi);
			
			aRepo.save(acc);
			return "pages/register/madeAccount.jsp";
		}
	}
	
	
	
	
	

}
