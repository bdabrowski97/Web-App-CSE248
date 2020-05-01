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
public class AccountController {
	
	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/homePage")
	public String userHomePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		
		
		return "pages/user/userHomePage.jsp";
	}
	
	@RequestMapping("/accountInfoSettings")
	public String userInfoSettings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername"); // grabs user info
		Account acc = aRepo.findById(username).get();
		
		
		
		return "pages/user/userInfoSettings.jsp";
		
		
	}
	
	@RequestMapping("/accountInfoSettingsFunction")
	public String changeUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername"); // grabs user info
		Account acc = aRepo.findById(username).get();
		
		
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
		
		
		acc.setPassword(enteredPassword);
		acc.setName(new Name(enteredFirst, enteredLast));
		Address newAddress = new Address(enteredStreet, enteredCity, enteredState, enteredZip, enteredCountry);
		acc.setAddress(newAddress);
		
		aRepo.save(acc);
		
		
		return "pages/user/accountSettings.jsp";
	}
	
	@RequestMapping("/viewMyAccountInfo")
	public String viewMyAccountInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		model.addAttribute("modelName",acc.getName().toString());
		model.addAttribute("modelAddress", acc.getAddress().toString());
		model.addAttribute("modelPaymentInfo",acc.getPaymentInfo().toString());
		
		
		return "pages/user/viewMyAccountInfo.jsp";
		
	}
	
	@RequestMapping("/changePaymentInfo")
	public String changePaymentInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		return "pages/user/changePaymentInfo.jsp";
	}
	
	@RequestMapping("changePaymentInfoFunction")
	public String changePaymentInfo2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String userame = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(userame).get();
		
		String num = (String) request.getParameter("num");
		String cvc = (String) request.getParameter("cvc");
		String expdate = (String) request.getParameter("expdate");
		
		num = num.trim();
		cvc = cvc.trim();
		expdate = expdate.trim();
		if (num.equals("0") && cvc.equals("0") && expdate.equals("0")) {
			acc.getPaymentInfo().setMainNum("no");
			acc.getPaymentInfo().setSecurityCode("payment");
			acc.getPaymentInfo().setExperationDate("info");
			aRepo.save(acc);
			return "pages/user/accountSettings.jsp";
		}
		
		if (num.length() != 16 || cvc.length() != 3 || expdate.length() != 4) {
			return "pages/user/changePaymentInfoInvalid.jsp";
		} else {
			acc.getPaymentInfo().setMainNum(num);
			acc.getPaymentInfo().setSecurityCode(cvc);
			acc.getPaymentInfo().setExperationDate(expdate);
			aRepo.save(acc);
		}
		
		return "pages/user/accountSettings.jsp";
	}

	
	
	
	
	
	
	
}
