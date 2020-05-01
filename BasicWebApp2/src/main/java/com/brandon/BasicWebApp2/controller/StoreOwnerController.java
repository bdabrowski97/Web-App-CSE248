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
public class StoreOwnerController {
	
	@Autowired
	private PurchaseRepo oRepo;
	
	@Autowired
	private AccountRepo aRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	@RequestMapping("/storeSplash")
	public String storeSplash(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		
		
		if (acc.getStoreID() == 0) {
			return "pages/storeOwner/createStore.jsp";
		} else {
			return "pages/storeOwner/storeSplash.jsp";
		}
	}
	
	@RequestMapping("/createStoreFunction")
	public String createStoreFunction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		String name = request.getParameter("storeName");
		String tag = request.getParameter("storeTag");
		
		if (StringCheck.checkNullOrEmpty(name) == true || StringCheck.checkNullOrEmpty(tag) == true) {
			return "pages/storeOwner/createStoreError.jsp";
		}
		
		Store store = new Store(username, name, (int) (sRepo.count() + 1));
		store.setTags(tag);
		acc.setStoreID(store.getStoreID());
		aRepo.save(acc);
		sRepo.save(store);
		
		session.setAttribute("storedStoreName", store.getName());
		
		
		return "pages/storeOwner/createdStore.jsp";
	}
	
	
	
	
}
