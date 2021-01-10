package com.clysman.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clysman.dsdeliver.entities.Order;

public interface OrderReposity extends JpaRepository<Order, Long> {

}
