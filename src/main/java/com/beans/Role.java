package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@Column(name = "role")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role;
	
	private String role_name;
	
	public Role(){
		
	}
	
	public Role(int role,String role_name){
		this.role=role;
		this.role_name = role_name;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
	
}
