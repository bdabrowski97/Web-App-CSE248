package com.brandon.BasicWebApp2.controller;

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
import com.brandon.BasicWebApp2.dao.ItemRepo;
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
	
	@Autowired
	private ItemRepo iRepo;
	
	
	
	@RequestMapping("/shopSplash")
	public String shopSplash(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		
		
		return "pages/user/shopSplash.jsp";
	}
	
	
	@RequestMapping("/browseStores")
	public String browseStores(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		Iterable<Store> iterable = sRepo.findAll();
		Collection<Store> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		session.setAttribute("allStores", collection);
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		cart.clearItems();
		session.setAttribute("cart", cart);
		
		return "pages/user/browseStores.jsp";
	}
	
	@RequestMapping("/browseItems")
	public String browseItems(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		int shopID = Integer.parseInt(request.getParameter("shopID"));
		System.out.println("GOT ID: " + shopID);
		Store store = sRepo.findById(shopID).get();
		session.setAttribute("shopHere", store);
		
		Iterable<Item> iterable = iRepo.findAll();
		ArrayList<Item> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<Item> itemsInThisStore = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).getStoreID() == store.getStoreID()) {
				itemsInThisStore.add(collection.get(i));
			}
		}
		
		session.setAttribute("itemsInThisStore", itemsInThisStore);
		
		
		return "pages/user/browseItems.jsp";
	}
	
	@RequestMapping("/addToCart")
	public String addToCart(HttpServletRequest request) {
		
		return null;
	}
	
	
	
	
	
	
	
	
	
}
