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
/**
 * Controller for admin specific functionality
 * @author bdabr
 *
 */
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
	
	/**
	 * Displays menu for managing the website
	 * @param request Used to recieve data
	 * @return
	 */
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
	
	/**
	 * Views all acccounts on website
	 * @param request Used to recieve data
	 * @return
	 */
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
	
	/**
	 * Views all stores on website
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/viewAllStores")
	public String viewStores(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Iterable<Store> iterable = sRepo.findAll();
		Collection<Store> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		Store[] stores = collection.toArray(new Store[collection.size()]);
		session.setAttribute("allStores", stores);
		
		
		return "pages/admin/viewAllStores.jsp";
	}
	
	/**
	 * Views all purchases made on website
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/viewAllPurchases")
	public String viewAllPurchases(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Iterable<Purchase> iterable = oRepo.findAll();
		ArrayList<Purchase> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		session.setAttribute("storeWidePurchases", collection);
		
		
		return "pages/admin/viewAllPurchases.jsp";
	}
	
	/**
	 * Lets admin take a closer look at a specific account's user information
	 * @param request Used to recieve data
	 * @param model Displays data on next page
	 * @return
	 */
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
		session.setAttribute("inspectingAccount", accInspecting);
		
		
		return "pages/admin/inspectAccount.jsp";
	}
	
	/**
	 * Lets admin view purchases made by the user they have inspected
	 * @param request Used to recieve data
	 * @return 
	 */
	@RequestMapping("/inspectAccountPurchases")
	public String inspectAccountPurchases(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Account accInspect = (Account) session.getAttribute("inspectingAccount");
		
		Iterable<Purchase> iterable = oRepo.findAll();
		Collection<Purchase> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		Purchase[] purchases = collection.toArray(new Purchase[collection.size()]);
		
		ArrayList<Purchase> theirPurchases = new ArrayList<>();
		for (int i = 0; i < purchases.length;i++) {
			if (accInspect.getUsername().equals(purchases[i].getUserID())) {
				theirPurchases.add(purchases[i]);
			}
		}
		
		session.setAttribute("theirPurchases", theirPurchases);
		
		
		
		
		return "pages/admin/inspectAccountPurchases.jsp";
	}
	
	/**
	 * View info on a specific purchase someone has made
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/adminViewPurchase")
	public String adminViewPurchase(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		int id = Integer.parseInt(request.getParameter("purchaseID"));
		
		Purchase sale = oRepo.findById(id).get();
		session.setAttribute("viewThisPurchase", sale);
		
		Iterable<ItemBought> iterable = ibRepo.findAll(); // finding max itemID available
		ArrayList<ItemBought> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<ItemBought> itemsInSale = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (sale.getPurchaseID() == collection.get(i).getOrderID()) {
				itemsInSale.add(collection.get(i));
			}
		}
		
		session.setAttribute("viewThisPurchaseItems", itemsInSale);
		
		return "pages/admin/adminViewPurchase.jsp";
	}
	
	/**
	 * View more information on a purchase made
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/adminViewPurchase2")
	public String adminViewPurchase2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		int id = Integer.parseInt(request.getParameter("purchaseID"));
		
		Purchase sale = oRepo.findById(id).get();
		
		
		session.setAttribute("viewThisPurchase", sale);
		
		Iterable<ItemBought> iterable = ibRepo.findAll(); // finding max itemID available
		ArrayList<ItemBought> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<ItemBought> itemsInSale = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (sale.getPurchaseID() == collection.get(i).getOrderID()) {
				itemsInSale.add(collection.get(i));
			}
		}
		
		session.setAttribute("viewThisPurchaseItems", itemsInSale);
		
		return "pages/admin/adminViewPurchase2.jsp";
	}
	
	/**
	 * Ovverides a purchase made by an account and cancels it
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/adminCancelOrder")
	public String adminCancelOrder(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Purchase purchase = (Purchase) session.getAttribute("viewThisPurchase");
		
		purchase.setCanceled(true);
		oRepo.save(purchase);
		
		return "pages/admin/adminCancelOrder.jsp";
	}
	
	/**
	 * Ovverides a purchase made by an account and cancels it
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/adminCancelOrder2")
	public String adminCancelOrder2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Purchase purchase = (Purchase) session.getAttribute("viewThisPurchase");
		purchase.setCanceled(true);
		oRepo.save(purchase);
		
		return "pages/admin/adminCancelOrder2.jsp";
	}
	
	/**
	 * View information about a specific store
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/inspectStore")
	public String inspectStore(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		if (request.getParameter("store").equals(null) || request.getParameter("store").equals("")) {
			return "pages/admin/viewAllStores.jsp";
		}
		int id =  Integer.parseInt(request.getParameter("store"));
		if (sRepo.existsById(id) == false) { return "pages/admin/viewAllStores.jsp"; }
		
		Store store = sRepo.findById(id).get();
		
		Iterable<Purchase> iterable = oRepo.findAll();
		ArrayList<Purchase> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<Purchase> storeSales = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i).getStoreID() == store.getStoreID()) {
				storeSales.add(collection.get(i));
			}
		}
		
		session.setAttribute("store", store);
		session.setAttribute("sales", storeSales);
		
		return "pages/admin/inspectStore.jsp";
	}
	
	/**
	 * Ovverides a store and forces it to close
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/forceClose")
	public String forceClose(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { // checking for valid login
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isAdmin() == false) { return "pages/home.jsp"; }
		
		Store store = (Store) session.getAttribute("store");
		store.setOpen(false);
		sRepo.save(store);
		
		
		return "pages/admin/forceClose.jsp";
	}
	
}
