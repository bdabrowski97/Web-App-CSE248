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
import com.brandon.BasicWebApp2.dao.PurchaseRepo;
import com.brandon.BasicWebApp2.dao.StoreRepo;
import com.brandon.BasicWebApp2.model.*;
/**
 * Non-specific pages for the website (home/meme)
 * @author bdabr
 *
 */
@Controller
public class HTMLController {
	

	@Autowired
	private AccountRepo aRepo;
	
	@Autowired 
	private PurchaseRepo oRepo;
	
	@Autowired
	private StoreRepo sRepo;
	
	@Autowired
	private ItemBoughtRepo ibRepo;
	
	
	/**
	 * Loads the home page for the website (create account or login)
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "pages/home.jsp";
	}
	
	/**
	 * Used to display an image
	 * @return
	 */
	@RequestMapping("/meme") // dumb joke
	public String meme() {
		return "pages/meme.jsp";
	}
	
	/**
	 * Displays accountSettings page
	 * @param request Used to recieve data
	 * @return
	 */
	@RequestMapping("/accountSettings") // login page
	public String accountSettingsPage(HttpServletRequest request) {	
		HttpSession session = request.getSession();
		if (session.getAttribute("storedUsername") == null) {
			return "pages/home.jsp";
		}
		String username = (String) session.getAttribute("storedUsername");
		Account acc = aRepo.findById(username).get();
		System.out.println(acc.toString());
		
		return "pages/user/accountSettings.jsp";
	}
	
	
	

}
