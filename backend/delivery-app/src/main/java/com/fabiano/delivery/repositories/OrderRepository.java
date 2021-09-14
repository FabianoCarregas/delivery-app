package com.fabiano.delivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiano.delivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
}
