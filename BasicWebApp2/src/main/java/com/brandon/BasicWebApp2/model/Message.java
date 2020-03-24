package com.brandon.BasicWebApp2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Class used for testing during basic milesotne phase of project
 * @author bdabr
 *
 */
@Entity
public class Message {
	
	@Id
	private int aid;
	private String message;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid; 
	}
	public String getAname() {
		return message;
	}
	public void setAname(String aname) {
		this.message = aname;
	}
	
	@Override
	public String toString() {
		return "Message [aid=" + aid + ",aname=" + message + "]";
	}
	
	

}
