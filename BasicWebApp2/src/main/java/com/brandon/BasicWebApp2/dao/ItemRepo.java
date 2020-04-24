package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Item;
import com.brandon.BasicWebApp2.model.ItemBought;
import com.brandon.BasicWebApp2.model.Purchase;

public interface ItemRepo extends CrudRepository<Item, Integer>{

}
