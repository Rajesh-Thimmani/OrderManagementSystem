package com.springboot.orderservice.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.orderservice.model.OrderModel;

public interface OrderService {

	public void createOrder(final OrderModel order) ;
	public List<OrderModel> getAllOrders() throws JsonProcessingException ;
}
