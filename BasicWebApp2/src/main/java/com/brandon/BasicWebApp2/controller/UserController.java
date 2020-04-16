package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brandon.BasicWebApp2.dao.AccountRepo;
import com.brandon.BasicWebApp2.dao.OrderRepo;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class UserController {
	
	@Autowired
	private OrderRepo orepo;
	
	@Autowired
	private AccountRepo arepo;
	
	@RequestMapping("/userHomePage")
	public String userHomePage() {
		return "pages/user/homePage.jsp";
	}
	
	@RequestMapping("/usernext")
	public String userNext() {
		return "pages/user/usernext.jsp";
	}

}
