package com.clysman.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clysman.dsdeliver.entities.Product;

public interface ProductReposity extends JpaRepository<Product, Long>{
	
	List<Product> findAllByOrderByNameAsc();
}
