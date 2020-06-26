package com.springboot.orderservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.orderservice.model.OrderModel;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Integer>{

	public List<OrderModel> findAll();
}
