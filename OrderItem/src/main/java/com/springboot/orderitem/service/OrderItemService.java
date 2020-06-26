package com.springboot.orderitem.service;

import java.util.List;

import com.springboot.orderitem.exceptiom.OrderItemNotFoundException;
import com.springboot.orderitem.model.OrderItem;

public interface OrderItemService {

	public void createOrderItem(final OrderItem student);
	public List<OrderItem> getAllOrderItems() throws  OrderItemNotFoundException;
}
