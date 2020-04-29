package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Integer>{

	public Items findByName(String name);
	
	public Items deleteByName(String name);
}
