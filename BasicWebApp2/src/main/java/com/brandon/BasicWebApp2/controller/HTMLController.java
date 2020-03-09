package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brandon.BasicWebApp2.dao.MsgRepo;
import com.brandon.BasicWebApp2.model.Message;
import com.brandon.BasicWebApp2.model.*;

@Controller
public class HTMLController {
	
	@Autowired
	private MsgRepo repo;
	
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addMsg")
	public String addMsg(Message msg) {
		repo.save(msg);
		return "home.jsp";
	}
	
	@RequestMapping("/meme")
	public String meme() {
		return "meme.jsp";
	}
	
	
	

}
