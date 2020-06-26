package com.springboot.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Entity annotation specifies that the class is mapped to a database table.
@Entity
public class OrderModel {

	// @Id annotation specifies the primary key of an entity.
	// @GeneratedValue provides the generation strategy specification for the primary key values.
	@Id
	@GeneratedValue
	private int orderId;
	private String customerName;
	private String shippingAddress;
	private String orderDate;
	//@OneToMany(mappedBy="student")
	//private List<OrderItem> orderItems;
	
	private int total;
	@JsonProperty("orderItem")
	private String orderItem;

	// Default constructor.
	public OrderModel() {	}

	public OrderModel(int orderId, String customerName, String shippingAddress, String orderDate,
			 int total) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}
	
}
