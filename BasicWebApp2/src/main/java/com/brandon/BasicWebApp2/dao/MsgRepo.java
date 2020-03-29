package com.brandon.BasicWebApp2.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Message;

public interface MsgRepo extends CrudRepository<Message,Integer> {
	
	

}
