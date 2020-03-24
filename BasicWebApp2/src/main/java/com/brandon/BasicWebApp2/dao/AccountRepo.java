package com.brandon.BasicWebApp2.dao;

import org.springframework.data.repository.CrudRepository;
import com.brandon.BasicWebApp2.model.Account;

public interface AccountRepo extends CrudRepository<Account, String> {

}
