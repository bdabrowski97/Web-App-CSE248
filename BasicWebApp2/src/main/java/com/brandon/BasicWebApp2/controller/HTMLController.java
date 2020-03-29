package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brandon.BasicWebApp2.dao.AccountRepo;
import com.brandon.BasicWebApp2.dao.MsgRepo;
import com.brandon.BasicWebApp2.model.Message;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class HTMLController {
	
	@Autowired
	private MsgRepo repo;
	
	@Autowired
	private AccountRepo arepo;
	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addMsg")
	public String addMsg(Message msg) {
		repo.save(msg);
		return "home.jsp";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register.jsp";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser() {
		return "registerUser.jsp";
	}
	
	@RequestMapping("/addUser")
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
		model.addAttribute("username", enteredUsername);
		
		Name name = new Name(enteredFirst, enteredLast);
		Address address = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
		Account acc = new Account(enteredUsername, enteredPassword, name, address);
		arepo.save(acc);
		
		return "test.jsp";
		
	}
	
	@RequestMapping("/meme")
	public String meme() {
		return "meme.jsp";
	}
	
	
	

}
