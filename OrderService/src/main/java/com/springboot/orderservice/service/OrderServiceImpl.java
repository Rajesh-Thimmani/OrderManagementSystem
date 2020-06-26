package com.springboot.orderservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.orderservice.model.OrderItem;
import com.springboot.orderservice.model.OrderModel;
import com.springboot.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderRepository orderRepository;
	@Autowired
    private RestTemplate restTemplate;
	
	public void createOrder(final OrderModel order) {
		orderRepository.save(order);
	}
	public List<OrderModel> getAllOrders() throws JsonProcessingException {
	
		final List<OrderModel> students = new ArrayList<>();
		String url = "http://localhost:10090/orderitem/getAllOrderItems";
        Object s= restTemplate.getForObject(url, Object.class);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(s);
        orderRepository.findAll().stream()
        	.peek(student->student.setOrderItem(jsonString))
        	.forEach(student -> students.add(student));
      return students;
	}
}

