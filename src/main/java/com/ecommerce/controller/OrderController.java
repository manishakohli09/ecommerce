package com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Orders;
import com.ecommerce.service.EcommerceService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private EcommerceService eService;
	
	@GetMapping
	public ResponseEntity<List<Orders>> getOrders(){
		List<Orders> orders=eService.getAllOrder();
		return ResponseEntity.ok(orders);
	}
	
	@PostMapping
	public ResponseEntity<Orders> addOrders(@RequestBody @Valid Orders order) {
		if(order.getItemList()!=null) {
			order.getItemList().forEach(i->i.setOrder(order));
		}
		
		return ResponseEntity.ok(eService.addOrder(order));
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Orders> viewOrder(@PathVariable int id) {
		Orders order=eService.getOrder(id);
		return ResponseEntity.ok(order);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable int id, @RequestBody @Valid Orders order) {
		Orders currOrder=eService.getOrder(id);
		if(currOrder==null) {
			ResponseEntity.badRequest().body("Id Not Found");
		}
		
		return ResponseEntity.ok(order);
	}
	
	
	
	//**********************************8
	/*
	 * @Autowired
	 * private OrderService orderService;
	
	 * @GetMapping public ResponseEntity<List<Orders>> getAllOrders(){ return
	 * ResponseEntity.ok(orderService.findAllOrder()); }
	 * 
	 * @PostMapping public ResponseEntity<Orders> addOrder(@RequestBody Orders
	 * order){ return ResponseEntity.ok(orderService.saveOrder(order)); }
	 * 
	 * @PutMapping("/email/{email}") public ResponseEntity<Orders>
	 * updateOrderByEmail(@PathVariable String email,@RequestBody Orders order){
	 * Orders newOrder=orderService.findOrderByEmail(email); if(!(newOrder==null)) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(orderService.saveOrder(order)); }
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<Orders>
	 * updateOrderById(@PathVariable int id,@RequestBody Orders order){
	 * Optional<Orders> newOrder=orderService.findOrderById(id);
	 * if(!newOrder.isPresent()) { ResponseEntity.badRequest().body("Id Not Found");
	 * }
	 * 
	 * return ResponseEntity.ok(orderService.saveOrder(order)); }
	 * 
	 * @GetMapping("/email/{email}") public ResponseEntity<Orders>
	 * getOrderByEmail(@PathVariable String email){ Orders
	 * newOrder=orderService.findOrderByEmail(email); if(!(newOrder==null)) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(newOrder); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Orders> getOrderById(@PathVariable
	 * int id){ Optional<Orders> newOrder=orderService.findOrderById(id);
	 * if(!newOrder.isPresent()) { ResponseEntity.badRequest().body("Id Not Found");
	 * }
	 * 
	 * return ResponseEntity.ok(newOrder.get()); }
	 * 
	 * @DeleteMapping("/email/{email}") public ResponseEntity<Orders>
	 * deleteItemByName(@PathVariable String email){ Orders
	 * newOrder=orderService.findOrderByEmail(email); if(!(newOrder==null)) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(orderService.deleteOrderByEmail(email)); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Orders>
	 * deleteItemById(@PathVariable int id){ Optional<Orders>
	 * newOrder=orderService.findOrderById(id); if(!newOrder.isPresent()) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(orderService.deleteOrderById(id)); }
	 */
	
}
