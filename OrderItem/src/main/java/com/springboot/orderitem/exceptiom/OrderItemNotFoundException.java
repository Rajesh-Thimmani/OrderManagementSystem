package com.springboot.orderitem.exceptiom;

public class OrderItemNotFoundException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public OrderItemNotFoundException(String message)
{
	super(message);
}
}
