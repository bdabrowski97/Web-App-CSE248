package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brandon.BasicWebApp2.dao.AccountRepo;
import com.brandon.BasicWebApp2.dao.MsgRepo;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class RegisterController {
	

	@Autowired
	private MsgRepo repo;
	
	@Autowired
	private AccountRepo arepo;
	
	
	
	@RequestMapping("/register") // choose which account type you want
	public String register() {
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
		
		if (enteredUsername.equals("ADMIN_CREATION") && enteredPassword.equals("ADMIN_CREATION")) {
			return "registerAdmin.jsp";
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(false);
			acc.setStoreOwner(false);	
			arepo.save(acc);
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
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(false);
			acc.setStoreOwner(true);
			arepo.save(acc);
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
		model.addAttribute("username", enteredUsername);
		
		if (enteredUsername.equals("ADMIN_CREATION") && enteredPassword.equals("ADMIN_CREATION")) {
			return "pages/register/registerAdmin.jsp";
		} else {
			Name name = new Name(enteredFirst, enteredLast);
			Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
			Account acc = new Account(enteredUsername, enteredPassword, name, address);
			acc.setAdmin(true);
			acc.setStoreOwner(false);
			arepo.save(acc);
			return "pages/register/madeAdmin.jsp";
		}
	}
	
	
	
	
	

}
