package com.springboot.orderitem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.orderitem.exceptiom.OrderItemNotFoundException;
import com.springboot.orderitem.model.OrderItem;
import com.springboot.orderitem.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	OrderItemRepository orderItemrepository;

	// Save orderItem entity in the h2 database.
	public void createOrderItem(final OrderItem orderItem) {
		orderItemrepository.save(orderItem);
	}

	// Get all students from the h2 database.
	public List<OrderItem> getAllOrderItems() throws  OrderItemNotFoundException {
		final List<OrderItem> students = new ArrayList<>();
		orderItemrepository.findAll().forEach(student -> students.add(student));
		return students;
	}
}
