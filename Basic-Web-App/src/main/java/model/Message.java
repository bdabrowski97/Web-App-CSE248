package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	private int id;
	private String message;
	
	public Message() {
		
	}
	
	public Message(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
