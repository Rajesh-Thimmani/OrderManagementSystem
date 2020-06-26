package com.springboot.orderservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.orderservice.model.OrderModel;
import com.springboot.orderservice.service.OrderServiceImpl;

@RestController		
public class OrderServiceController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	OrderServiceImpl orderservice;
	
	@Autowired
    private RestTemplate restTemplate;

	// Save order entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value= "/create/order")
	public int save(final @RequestBody @Valid OrderModel orderModel) {
		log.info("Saving order details in the database.");
		orderservice.createOrder(orderModel);
		return orderModel.getOrderId();
	}

	
	@GetMapping(value= "/order/getAllOrders", produces= "application/vnd.jcg.api.v1+json")
	public List<OrderModel> getAllOrders() throws JsonProcessingException {
		log.info("Getting order details from the database.");
		return orderservice.getAllOrders();
	}
}
