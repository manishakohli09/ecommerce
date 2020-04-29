package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Items;
import com.ecommerce.service.EcommerceService;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private  EcommerceService eService;
	
	
	@GetMapping
	public  List<Items> getAllItems(){
		List<Items> items=eService.getAllItems();
		return (items);
	}
	
	@PostMapping
	public ResponseEntity<Items> addItems(@RequestBody @Valid Items item){
		return ResponseEntity.ok(eService.addItem(item));
	}
	
	@GetMapping("/{id}")
	public Items getItems(@PathVariable int id){
		Items item=eService.getItem(id);
		return (item);		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Items> updateItem(@PathVariable int id,@RequestBody @Valid Items item){
		Items currItem=eService.getItem(id);
		if(currItem==null) {
			ResponseEntity.badRequest().body("Id Not Found");
		}
		
		return ResponseEntity.ok(eService.addItem(item));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Items> deleteById(@PathVariable int id) {
		Items currItem=eService.getItem(id);
		if(currItem==null) {
			ResponseEntity.badRequest().body("Id Not Found");
		}
		
		return ResponseEntity.ok(eService.deleteItem(id));
	}
	
	//********************************************88
	/*
	 * @Autowired private ItemService itemService;
	 * 
	 * @GetMapping public ResponseEntity<List<Items>> getAllItems(){ return
	 * ResponseEntity.ok(itemService.findAllItems()); }
	 * 
	 * @PostMapping public ResponseEntity<Items> addItem(@RequestBody Items item){
	 * return ResponseEntity.ok(itemService.saveItem(item)); }
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<Items> updateItem(@PathVariable
	 * int id,@RequestBody Items item){ Optional<Items>
	 * newItem=itemService.findById(id); if(!newItem.isPresent()) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(itemService.saveItem(item)); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<Items> getItem(@PathVariable int
	 * id){ Optional<Items> newItem=itemService.findById(id);
	 * if(!newItem.isPresent()) { ResponseEntity.badRequest().body("Id Not Found");
	 * } return ResponseEntity.ok(newItem.get()); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Items> deleteById(@PathVariable
	 * int id){ Optional<Items> newItem=itemService.findById(id);
	 * if(!newItem.isPresent()) { ResponseEntity.badRequest().body("Id Not Found");
	 * }
	 * 
	 * return ResponseEntity.ok(itemService.deleteById(id)); }
	 * 
	 * @DeleteMapping("/{name}") public ResponseEntity<Items>
	 * deleteItemByName(@PathVariable String name){ Items
	 * newItem=itemService.findItemByName(name); if(!(newItem==null)) {
	 * ResponseEntity.badRequest().body("Id Not Found"); }
	 * 
	 * return ResponseEntity.ok(itemService.deleteItemByName(name)); }
	 */
}
