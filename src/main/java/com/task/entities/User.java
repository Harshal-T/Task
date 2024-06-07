package com.task.entities;

import jakarta.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private String name;
	private String email;
	private String contact_no;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public User(String name, String email, String contact_no) {
		super();
		this.name = name;
		this.email = email;
		this.contact_no = contact_no;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	

}
