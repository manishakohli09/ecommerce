package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

	public Orders findByEmail(String email);
	
	public Orders deleteByEmail(String email);
}
