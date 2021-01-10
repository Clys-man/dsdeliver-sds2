package com.clysman.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clysman.dsdeliver.dto.OrderDTO;
import com.clysman.dsdeliver.entities.Order;
import com.clysman.dsdeliver.repositories.OrderReposity;

@Service
public class OrderService {
	
	@Autowired
	private OrderReposity repository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
