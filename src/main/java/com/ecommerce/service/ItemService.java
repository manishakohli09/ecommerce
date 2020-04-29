package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Items;
import com.ecommerce.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;
	
	//Retrieval operation
	public List<Items> findAllItems(){
		return itemRepo.findAll();
	}
	
	//Creation operation
	public Items saveItem(Items item) {
		return itemRepo.save(item);
	}
	
	//Update Operation
	public Items updateItem(Items item) {
		int id=item.getId();
		Items newItem=null;
		if(itemRepo.existsById(id)) {
			itemRepo.save(item);
			newItem=item;
		}
		
		return newItem;
	}

	//Search Operation by id
	public Optional<Items> findById(int id) {
		return itemRepo.findById(id);
	}
	//Search Operation
	public Items findItemByName(String itemName) {
		return itemRepo.findByName(itemName);
	}
	
	//Deletion Operation
	public Items deleteById(int id) {
		Items deletedItem=null;
		if(itemRepo.findById(id).isPresent()) {
			deletedItem=itemRepo.findById(id).get();
			itemRepo.deleteById(id);
		}
		
		return deletedItem;
	}
		
	//Deletion Operation
	public Items deleteItemByName(String itemName) {
		Items deletedItem=null;
		if(!(itemRepo.findByName(itemName)==null)) {
			deletedItem=itemRepo.findByName(itemName);
			itemRepo.deleteByName(itemName);
		}
		return deletedItem;
	}
}
