package com.brandon.BasicWebApp2.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
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
public class AdminController {
	
	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/managementMenu")
	public String managementMenu(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		
		return "pages/admin/managementMenu.jsp";
	}
	
	@RequestMapping("/viewAllAccounts")
	public String viewAccounts(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		
		Iterable<Account> iterable = aRepo.findAll();
		Collection<Account> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		Account[] accs = collection.toArray(new Account[collection.size()]);
		session.setAttribute("allAccounts", accs);
		
		return "pages/admin/viewAllAccounts.jsp";
	}
	
	@RequestMapping("/inspectAccount")
	public String inspectAccount(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		String accInspect = request.getParameter("username");
		
		if (StringCheck.checkNullOrEmpty(accInspect) == true) { // inspecting non-existant account
			return "pages/admin/viewAllAccountsInvalid.jsp";
		}
		
		
		session.setAttribute("viewThisAccount", accInspect);
		
		if (aRepo.existsById(accInspect) == false) { // expecting non-existant account
			return "pages/admin/viewAllAccountsInvalid.jsp";
		}
		
		Account accInspecting = aRepo.findById(accInspect).get();
		
		String name = accInspecting.getName().toString();
		String password = accInspecting.getPassword().toString();
		String address = accInspecting.getAddress().toString();
		
		model.addAttribute("theirName", name);
		model.addAttribute("theirPassword", password);
		model.addAttribute("theirAddress", address);
		
		
		return "pages/admin/inspectAccount.jsp";
	}
	
	
	
	
}
