package com.springboot.orderitem.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.orderitem.exceptiom.OrderItemNotFoundException;
import com.springboot.orderitem.model.OrderItem;
import com.springboot.orderitem.service.OrderItemServiceImpl;

@RestController		// Useful to create the RESTful webservices.
public class OrderItemController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	OrderItemServiceImpl orderItemService;

	// Save order item entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value= "/create/orderitem")
	public int save(final @RequestBody @Valid OrderItem orderItem) {
		log.info("Saving order details in the database.");
		orderItemService.createOrderItem(orderItem);
		return orderItem.getOrderId();
	}

	// Get all students from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/orderitem/getAllOrderItems", produces= "application/vnd.jcg.api.v1+json")
	public List<OrderItem> getAllOrderItems() {
		log.info("Getting order item details from the database.");
		List<OrderItem> allOrderItem=null;
		try {
			 allOrderItem=	 orderItemService.getAllOrderItems();
		} catch (OrderItemNotFoundException e) {
			e.printStackTrace();
		}
		return allOrderItem;
	}
}
