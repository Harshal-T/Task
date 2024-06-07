package com.task.entities;

import jakarta.persistence.*;

@Entity
public class Stakeholder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String type;
	private String role;
	
	
	
	public Stakeholder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Stakeholder(String type, String name, String email, String password, String role) {
		super();
		this.type = type;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
