package com.fabiano.delivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabiano.delivery.dto.OrderDTO;
import com.fabiano.delivery.dto.ProductDTO;
import com.fabiano.delivery.entities.Order;
import com.fabiano.delivery.entities.Product;
import com.fabiano.delivery.entities.enuns.OrderStatus;
import com.fabiano.delivery.repositories.OrderRepository;
import com.fabiano.delivery.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly =  true)
	public List<OrderDTO> findAll(){
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	@Transactional
	public OrderDTO insert(OrderDTO dto){
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getById(p.getId());
			order.getProducts().add(product);
		}
		order = orderRepository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = orderRepository.getById(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepository.save(order);
		return new OrderDTO(order);
		
	}
	
}
