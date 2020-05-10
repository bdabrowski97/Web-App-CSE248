package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.brandon.BasicWebApp2.dao.PurchaseRepo;
import com.brandon.BasicWebApp2.model.Purchase;

/**
 * Service class for purchases
 * @author bdabr
 *
 */
@Service
public class PurchaseService {
	private PurchaseRepo repo;
	
	public ArrayList<Purchase> getAllOrders(){
		ArrayList<Purchase> orders = new ArrayList<>();
		repo.findAll().forEach(orders::add);
		return orders;
	}
	
	
}
