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
public class UserController {
	
	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/userHomePage")
	public String userHomePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		return "pages/user/homePage.jsp";
	}
	
	@RequestMapping("/userInfoSettings")
	public String userInfoSettings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		return "pages/user/userInfoSettings.jsp";
	}
	
	@RequestMapping("/changeUserInfo")
	public String changeUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		
		String enteredPassword = request.getParameter("password");
		String enteredFirst = request.getParameter("firstName");
		String enteredLast = request.getParameter("lastName");
		String enteredStreet = request.getParameter("street");
		String enteredCity = request.getParameter("city");
		String enteredState = request.getParameter("state");
		String enteredZip = request.getParameter("zipCode");
		String enteredCountry = request.getParameter("country");
		
		enteredPassword = enteredPassword.trim(); // trim all to ensure validity
		enteredFirst = enteredFirst.trim();
		enteredLast = enteredLast.trim();
		enteredStreet = enteredStreet.trim();
		enteredCity = enteredCity.trim();
		enteredState = enteredState.trim();
		enteredZip = enteredZip.trim();
		enteredCountry = enteredCountry.trim();
		
		if (StringCheck.checkNullOrEmpty(enteredPassword) == true || 
				StringCheck.checkNullOrEmpty(enteredFirst) == true || StringCheck.checkNullOrEmpty(enteredLast) == true ||
				StringCheck.checkNullOrEmpty(enteredStreet) == true || StringCheck.checkNullOrEmpty(enteredCity) == true ||
				StringCheck.checkNullOrEmpty(enteredState) == true || StringCheck.checkNullOrEmpty(enteredZip) == true ||
				StringCheck.checkNullOrEmpty(enteredCountry) == true) {
			return "pages/user/userInfoSettingsInvalid.jsp";
		}  // check all for validity
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		acc.setPassword(enteredPassword);
		acc.setName(new Name(enteredFirst, enteredLast));
		Address newAddress = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
		acc.setAddress(newAddress);
		
		aRepo.save(acc);
		
		return "pages/user/homePage.jsp";
	}
	

}
