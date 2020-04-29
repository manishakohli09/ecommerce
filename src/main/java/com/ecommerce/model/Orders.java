package com.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	private int orderId;
	
	private String email;
	
	@OneToMany(mappedBy="order")
	private List<OrderItem> itemList;


	@ManyToMany
	private List<SiteUsers> userList;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<SiteUsers> getUserList() {
		return userList;
	}

	public void setUserList(List<SiteUsers> userList) {
		this.userList = userList;
	}
	
	
	
}
