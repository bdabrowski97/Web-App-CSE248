package com.brandon.BasicWebApp2.controller;

import java.sql.ResultSet;
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
		session.setAttribute("storedStoreTag", tag);
		session.setAttribute("storedStoreName", name);
		aRepo.save(acc);
		sRepo.save(store);
		
		session.setAttribute("storedStoreName", store.getName());
		
		
		return "pages/storeOwner/storeSplash.jsp";
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
	
	
	
}
