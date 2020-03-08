package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;

import com.brandon.BasicWebApp2.model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

}
