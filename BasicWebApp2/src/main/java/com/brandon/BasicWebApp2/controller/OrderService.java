package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.brandon.BasicWebApp2.dao.OrderRepo;
import com.brandon.BasicWebApp2.model.Order;

@Service
public class OrderService {
	private OrderRepo repo;
	
	public ArrayList<Order> getAllOrders(){
		ArrayList<Order> orders = new ArrayList<>();
		repo.findAll().forEach(orders::add);
		return orders;
	}
	
	public Order getOrder(int id) {
		return repo.findById(id).get();
	}
}
