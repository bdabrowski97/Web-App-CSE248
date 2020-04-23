package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Purchase;
import com.brandon.BasicWebApp2.model.Store;

public interface StoreRepo extends CrudRepository<Store, Integer>{

}
