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
		ArrayList<Store> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<Store> allStores = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).isOpen() == true) {
				allStores.add(collection.get(i));
			}
		}
		
		session.setAttribute("allStores", allStores);
		
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
		
		if (sRepo.existsById(shopID) == false) { return "pages/user/browseStores.jsp"; }
		
		
		Store store = sRepo.findById(shopID).get();
		
		if (store.isOpen() == false) { return "pages/user/browseStores.jsp"; }
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
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		/*
		 * get itemID
		 * compare to all stores
		 * if in store that matches id we're in and is open then we're good
		 */
		
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		if (iRepo.existsById(itemID) == false) { return "pages/user/browseItems.jsp"; }
		
		Item itemToAdd = iRepo.findById(itemID).get();
		Store store = (Store) session.getAttribute("shopHere");
		if (itemToAdd.getStoreID() != store.getStoreID()) { return "pages/user/browseItems.jsp";}
		
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		cart.addItem(itemToAdd);
		session.setAttribute("cart", cart);
		
		return "pages/user/browseItems.jsp";
	}
	
	
	@RequestMapping("/viewCart")
	public String viewCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		
		return "pages/user/viewCart.jsp";
	}
	
	
	@RequestMapping("checkOut")
	public String checkout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // verfying user account
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == true || acc.isStoreOwner() == true) {
			return "pages/home.jsp";
		}
		
		PaymentInfo card = acc.getPaymentInfo();
		if (card.paymentValid() == false) { return "pages/user/viewCartInvalid.jsp"; }
		
		
		//Process the order
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		Purchase purchase = new Purchase();
		if (oRepo.count() < 1) {
			purchase.setPurchaseID(0);
		} else {
			int max = 0;
			Iterable<Purchase> iterable = oRepo.findAll();
			ArrayList<Purchase> collection = new ArrayList<>();
			iterable.forEach(collection::add);
			for (int i = 0; i < collection.size(); i++) {
				if (max < collection.get(i).getPurchaseID()) {
					max = collection.get(i).getPurchaseID();
				}
			}
			max++;
			purchase.setPurchaseID(max);
		}
		
		Store store = (Store) session.getAttribute("shopHere");
		purchase.setStoreID(store.getStoreID());
		purchase.setCanceled(false);
		purchase.setStoreName(store.getName());
		purchase.setUserID(acc.getUsername());
		purchase.setSubTotal(cart.getSubtotal());
		purchase.setTotal(cart.getPrice());
		
		
		ArrayList<Item>	itemsBeingBought = cart.getItems();
		for (int i = 0; i < itemsBeingBought.size(); i++) {
			Item storeThis = itemsBeingBought.get(i);
			ItemBought itemBought = new ItemBought(storeThis.getName(), storeThis.getDescription(), storeThis.getPrice());
			itemBought.setOrderID(purchase.getPurchaseID());
			
			if (ibRepo.count() < 1) {
				itemBought.setPurchaseID(0);
			} else {
				int max2 = 0;
				Iterable<ItemBought> iterable = ibRepo.findAll();
				ArrayList<ItemBought> collection = new ArrayList<>();
				iterable.forEach(collection::add);
				for (int k = 0; k < collection.size(); k++) {
					if (max2 < collection.get(k).getPurchaseID()) {
						max2 = collection.get(k).getPurchaseID();
					}
				}
				max2++;
				itemBought.setPurchaseID(max2);
			}
			ibRepo.save(itemBought);
		}
		
		oRepo.save(purchase);
		
		
	
		return "pages/user/checkOut.jsp";
	}
	
	
	
	
	
	
	
}
