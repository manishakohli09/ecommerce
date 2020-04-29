package com.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SiteUsers {

	@Id
	private int id;
	private String name;
	private String email;
	//Can be a seller or a buyer
	private String role;
	
	@ManyToMany(mappedBy="userList")
	List<Orders> orders;
	/*
	 * @ManyToMany(mappedBy="userList") List<Items> items;
	 */
	
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	/*
	 * public List<Items> getItems() { return items; } public void
	 * setItems(List<Items> items) { this.items = items; }
	 */
	
	
	
}
