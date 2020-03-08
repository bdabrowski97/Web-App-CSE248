package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


import com.brandon.BasicWebApp2.dao.MsgRepo;
import com.brandon.BasicWebApp2.model.*;

@Service
public class MsgService {
	
	private MsgRepo repo;
	
	public ArrayList<Message> getAllAlien(){
		ArrayList<Message> msgs = new ArrayList<>();
		repo.findAll().forEach(msgs::add);
		return msgs;
	}
	
	public Message getMsg(int id) {
		return repo.findById(id).get();
	}
	
	
	
}
