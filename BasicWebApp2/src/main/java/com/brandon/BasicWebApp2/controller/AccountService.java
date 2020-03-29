package com.brandon.BasicWebApp2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.brandon.BasicWebApp2.dao.AccountRepo;
import com.brandon.BasicWebApp2.model.Account;

@Service
public class AccountService {
	
	private AccountRepo repo;
	
	public ArrayList<Account> getAllAccounts(){
		ArrayList<Account> accounts = new ArrayList<>();
		repo.findAll().forEach(accounts::add);
		return accounts;
	}

}
