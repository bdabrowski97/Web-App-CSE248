package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
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
public class LoginController {
	
	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/login") // login page
	public String loginPage() {	
		return "pages/login/login.jsp";
	}
	
	@RequestMapping("/loginAccount") // form for logging in
	public String loginAccount(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		String enteredUsername = request.getParameter("username");
		String enteredPassword = request.getParameter("password");
		
		//model.addAttribute("username", enteredUsername);
		
		if (enteredUsername.equals("") || enteredUsername.equals(null)) {
			return "pages/login/loginInvalid.jsp";
		}
		
		if (aRepo.existsById(enteredUsername) == true) {
		
			Account acc = aRepo.findById(enteredUsername).get();
			
			if (acc.getPassword().equals(enteredPassword)) {
				
				session.setAttribute("storedUsername", enteredUsername); // saves the username to the server that we'll use for all the other pages when needed
				
				if (acc.isAdmin() == true) {
					return "pages/admin/adminHomePage.jsp";
				}
				
				
				if (acc.isStoreOwner() == true) {
					session.setAttribute("storedStoreID", acc.getStoreID()); // saves the storeID of the store you own
					if (acc.getStoreID() != 0) {
						Store store = sRepo.findById(acc.getStoreID()).get();
						session.setAttribute("storedStoreName", store.getName()); // saves the store name of the store you own
						session.setAttribute("storedStoreTag", store.getTags()); // saves the tag of the store you own
					}
					
					return "pages/storeOwner/storeOwnerHomePage.jsp";
				}
				
				
				return "pages/user/userHomePage.jsp";
				
			} else {
				return "pages/login/loginInvalid.jsp";
			}
			
		} else {
			return "pages/login/loginInvalid.jsp";
		}
		
	}
	

}
