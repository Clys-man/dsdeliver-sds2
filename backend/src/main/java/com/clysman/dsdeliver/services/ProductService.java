package com.clysman.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clysman.dsdeliver.dto.ProductDTO;
import com.clysman.dsdeliver.entities.Product;
import com.clysman.dsdeliver.repositories.ProductReposity;

@Service
public class ProductService {
	
	@Autowired
	private ProductReposity repository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
