package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Order;

public interface OrderRepo extends CrudRepository<Order, Integer>{

}
