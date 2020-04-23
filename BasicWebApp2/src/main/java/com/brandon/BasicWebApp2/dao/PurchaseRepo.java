package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Purchase;

public interface PurchaseRepo extends CrudRepository<Purchase, Integer>{

}
