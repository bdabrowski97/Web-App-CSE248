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

import com.brandon.BasicWebApp2.dao.OrderRepo;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class LoginController {
	

	@Autowired
	private OrderRepo orepo;
	
	@Autowired
	private AccountRepo arepo;
	
	@RequestMapping("/login") // login page
	public String loginPage() {
		return "pages/login/login.jsp";
	}
	
	@RequestMapping("/loginAccount") // form for logging in
	public String loginAccount(HttpServletRequest request, Model model) {
		String enteredUsername = request.getParameter("username");
		String enteredPassword = request.getParameter("password");
		model.addAttribute("username", enteredUsername);
		
		if (enteredUsername.equals("") || enteredUsername.equals(null)) {
			return "pages/login/loginInvalid.jsp";
		}
		
		if (arepo.existsById(enteredUsername) == true) {
			Optional<Account> acc = arepo.findById(enteredUsername);
			Account login = acc.get();
			
			if (login.getPassword().equals(enteredPassword)){
				System.out.println("access granted");
				
				return "pages/user/homePage.jsp";
			} else {
				return "pages/login/loginInvalid.jsp";
			}
			
		} else {
			return "pages/login/loginInvalid.jsp";
		}
		
	}
	

}
