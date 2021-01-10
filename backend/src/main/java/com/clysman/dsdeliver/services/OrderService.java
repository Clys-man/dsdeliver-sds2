package com.clysman.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clysman.dsdeliver.dto.OrderDTO;
import com.clysman.dsdeliver.dto.ProductDTO;
import com.clysman.dsdeliver.entities.Order;
import com.clysman.dsdeliver.entities.Product;
import com.clysman.dsdeliver.entities.enums.OrderStatus;
import com.clysman.dsdeliver.repositories.OrderReposity;
import com.clysman.dsdeliver.repositories.ProductReposity;

@Service
public class OrderService {

	@Autowired
	private OrderReposity repository;

	@Autowired
	private ProductReposity productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(),
				OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
}
