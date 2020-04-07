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
import com.brandon.BasicWebApp2.dao.MsgRepo;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class HTMLController {
	

	@Autowired
	private MsgRepo repo;
	
	@Autowired
	private AccountRepo arepo;
	
	
	@RequestMapping("/")
	public String home() {
		return "pages/home.jsp";
	}
	
	@RequestMapping("/addMsg")
	public String addMsg(Message msg) {
		repo.save(msg);
		return "pages/home.jsp";
	}
	
	@RequestMapping("/meme") // dumb joke
	public String meme() {
		return "pages/meme.jsp";
	}
	
	
	

}
