package com.springboot.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue
	private int orderId;
	private String productCode;
	private String productName;
	private String quntity;
	public OrderItem(int orderId, String productCode, String productName, String quntity) {
		super();
		this.orderId = orderId;
		this.productCode = productCode;
		this.productName = productName;
		this.quntity = quntity;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuntity() {
		return quntity;
	}
	public void setQuntity(String quntity) {
		this.quntity = quntity;
	}
	
	
	

}
