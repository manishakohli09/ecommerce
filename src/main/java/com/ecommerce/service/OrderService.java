package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Items;
import com.ecommerce.model.Orders;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	//Retrieval Operation
	public List<Orders> findAllOrder(){
		return orderRepo.findAll();
	}
	
	//Creation Operation
	public Orders saveOrder(Orders order) {		
		return orderRepo.save(order);
	}
	
	//Updation Operation
	public Orders updateOrder(Orders order) {
		int id=order.getOrderId();
		Orders newOrder=null;
		if(orderRepo.existsById(id)) {
			newOrder=order;
		}
		
		return newOrder;
	}
	
	//Retrieval Operation based on email
	public Orders findOrderByEmail(String email) {
		return orderRepo.findByEmail(email);
	}
	
	public Optional<Orders> findOrderById(int id) {
		return orderRepo.findById(id);
	}
	//Deletion operation based on email
	public Orders deleteOrderByEmail(String email) {
		Orders newOrder=orderRepo.findByEmail(email);
	
		if(!(newOrder==null)) {
			orderRepo.deleteByEmail(email);
		}
		
		return newOrder;
	}
	
	//Deletion operation based on id
		public Orders deleteOrderById(int id) {
			Orders newOrder=orderRepo.findById(id).get();
			
			if(!(newOrder==null)) {
				orderRepo.deleteById(id);
			}
			
			return newOrder;
		}
	
}
