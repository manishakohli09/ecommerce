package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Items;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.repository.OrderRepository;

@Service
public class EcommerceService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ItemRepository itemRepo;
	
	public List<Items> getAllItems(){
		return itemRepo.findAll();
	}
	
	public Items getItem(int id) {
		return itemRepo.findById(id).get();
	}
	
	public Items addItem(Items item) {
		return itemRepo.save(item);
	}
	
	public List<Orders> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public Orders getOrder(int id) {
		return orderRepo.findById(id).get();
	}
	
	public Orders addOrder(Orders order) {
		return orderRepo.save(order);
	}
	
	public Items deleteItem(int id) {
		Items item=null;
		if(itemRepo.findById(id)!=null) {
			item=itemRepo.findById(id).get();
			itemRepo.deleteById(id);
		}
		return item;
	}
	
	
}
