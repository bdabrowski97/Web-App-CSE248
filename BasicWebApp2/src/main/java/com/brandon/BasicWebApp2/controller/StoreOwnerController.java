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
import com.brandon.BasicWebApp2.dao.ItemRepo;
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
	
	@Autowired
	private ItemRepo iRepo;
	
	
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
		session.setAttribute("storedStoreTag", tag);
		session.setAttribute("storedStoreName", name);
		aRepo.save(acc);
		sRepo.save(store);
		
		session.setAttribute("storedStoreName", store.getName());
		
		
		return "pages/home.jsp";
	}
	
	@RequestMapping("/openOrClose")
	public String openOrClose(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		return "pages/storeOwner/openOrClose.jsp";
	}
	
	@RequestMapping("/openOrCloseOpen")
	public String openOrCloseFunction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		int id = (Integer) session.getAttribute("storedStoreID");
		Store store = sRepo.findById(id).get();
		store.setOpen(true);
		sRepo.save(store);
		session.setAttribute("loggedInStore", store);
		
		return "pages/storeOwner/storeSplash.jsp";
	}
	
	@RequestMapping("/openOrCloseClose")
	public String openOrCloseFunction2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		int id = (Integer) session.getAttribute("storedStoreID");
		Store store = sRepo.findById(id).get();
		store.setOpen(false);
		sRepo.save(store);
		session.setAttribute("loggedInStore", store);
		
		
		return "pages/storeOwner/storeSplash.jsp";
	}
	
	@RequestMapping("/changeStoreInfo")
	public String changeStoreInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		return "pages/storeOwner/changeStoreInfo.jsp";
	}
	
	@RequestMapping("/changeStoreInfoFunction")
	public String changeStoreInfoFunction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		Store store = sRepo.findById(acc.getStoreID()).get();
		String name = request.getParameter("storeName");
		String tag = request.getParameter("storeTag");
		
		if (StringCheck.checkNullOrEmpty(name) == true || StringCheck.checkNullOrEmpty(tag) == true) {
			return "pages/storeOwner/changeStoreInfoError.jsp";
		} else {
			
			store.setName(name);
			store.setTags(tag);
			session.setAttribute("storedStoreName", name);
			session.setAttribute("storedStoreTag", tag);
			
			sRepo.save(store);
			
			return "pages/storeOwner/storeSplash.jsp";
		}
		
	}
	
	@RequestMapping("/manageItems")
	public String manageItems(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		Store store = sRepo.findById(acc.getStoreID()).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		Iterable<Item> iterable = iRepo.findAll();
		Collection<Item> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		Item[] items = collection.toArray(new Item[collection.size()]);
		ArrayList<Item> myItems = new ArrayList<>();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getStoreID() == store.getStoreID()) {
				myItems.add(items[i]);
			}
		}
		
		session.setAttribute("myItems", myItems);
		
		
		
		return "pages/storeOwner/manageItems.jsp";
	}
	
	@RequestMapping("/createItem")
	public String createItem(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		
		return "pages/storeOwner/createItem.jsp";
	}
	
	@RequestMapping("/createItemFunction")
	public String createItemFunction(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		Store store = sRepo.findById(acc.getStoreID()).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		String itemName = request.getParameter("name");
		String itemDescription = request.getParameter("description");
		double itemPrice = Double.parseDouble(request.getParameter("price"));
		
		System.out.println("ITEMS: " + iRepo.count());												
		
		if (iRepo.count() < 1) {
			Item item = new Item(itemName,itemDescription,itemPrice);
			item.setStoreID(store.getStoreID());
			item.setItemID(1);
			iRepo.save(item);
																
			return "pages/storeOwner/storeSplash.jsp";
		} else {
			Item item = new Item(itemName, itemDescription, itemPrice);
			item.setStoreID(store.getStoreID());
			int max = 0;
			
			Iterable<Item> iterable = iRepo.findAll(); // finding max itemID available
			Collection<Item> collection = new ArrayList<>();
			iterable.forEach(collection::add);
			Item[] items = collection.toArray(new Item[collection.size()]);
			for (int i = 0; i< items.length;i++) {
				if (max < items[i].getItemID()) {
					max = items[i].getItemID();
					
				}
			}
			max++;
			item.setItemID(max);
			
			// IT ISNT WORKING ON THE FORM SUBMIT BUTTON
			
			iRepo.save(item);
			
			
			return "pages/storeOwner/storeSplash.jsp";
			
		}
		
	}
	
	
	
	@RequestMapping("/deleteThisItem")
	public String deleteThisitem(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) {
			return "pages/home.jsp";
		}
		
		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			return "pages/storeOwner/manageItems.jsp";
		}
		
		int id =  Integer.parseInt(request.getParameter("id"));
		if (iRepo.existsById(id) == true) {
			Item itemToDelete = iRepo.findById(id).get();
			if (acc.getStoreID() == itemToDelete.getStoreID()) { // verify the user own's the item they're about to delete
				iRepo.deleteById(id);
				return "pages/storeOwner/deletedItem.jsp";
			}
		}
		
		return "pages/storeOwner/deletedItemInvalid.jsp";
	}
	
	
	@RequestMapping("/viewSales")
	public String viewSales(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		
		if (acc.isStoreOwner() == false) { return "pages/home.jsp"; }
		
		Iterable<Purchase> iterable = oRepo.findAll(); // finding max itemID available
		ArrayList<Purchase> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<Purchase> sales = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (acc.getStoreID() == collection.get(i).getStoreID()) {
				sales.add(collection.get(i));
			}
		}
		
		session.setAttribute("sales", sales);
		
		
		
		return "pages/storeOwner/viewSales.jsp";
	}
	
	
	@RequestMapping("/viewSaleDetails")
	public String viewSaleDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { return "pages/home.jsp"; }
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isStoreOwner() == false) { return "pages/home.jsp"; }
		
		if (request.getParameter("purchaseID").equals(null) || request.getParameter("purchaseID").equals("")) {
			return "pages/storeOwner/viewSales.jsp";
		}
		
		int purchaseID = Integer.parseInt(request.getParameter("purchaseID"));
		if (oRepo.existsById(purchaseID) == false) { return "pages/storeOwner/viewSales.jsp";}
		
		Purchase sale = oRepo.findById(purchaseID).get();
		session.setAttribute("inspectSale", sale);
		
		Iterable<ItemBought> iterable = ibRepo.findAll(); // finding max itemID available
		ArrayList<ItemBought> collection = new ArrayList<>();
		iterable.forEach(collection::add);
		
		ArrayList<ItemBought> itemsInSale = new ArrayList<>();
		for (int i = 0; i < collection.size(); i++) {
			if (sale.getPurchaseID() == collection.get(i).getOrderID()) {
				itemsInSale.add(collection.get(i));
			}
		}
		
		session.setAttribute("itemsInSale", itemsInSale);
		
		
		return "pages/storeOwner/viewSaleDetails.jsp";
	}
	
	@RequestMapping("/cancelSale")
	public String cancelSale(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) { return "pages/home.jsp"; }
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		if (acc.isStoreOwner() == false) { return "pages/home.jsp"; }
		
		Purchase inspectSale = (Purchase) session.getAttribute("inspectSale");
		inspectSale.setCanceled(true);
		oRepo.save(inspectSale);
		
		
		return "pages/storeOwner/saleCancelled.jsp";
	}
	
	
	
	
	
	
	
	
	
}
