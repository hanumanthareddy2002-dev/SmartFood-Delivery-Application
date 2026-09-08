package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Order;
import com.nit.entity.OrderStatus;
import com.nit.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		Order savedOrder=orderservice.createOrder(order);
		return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return ResponseEntity.ok(orderservice.getAllOrders());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id){
		return ResponseEntity.ok(orderservice.getOrderById(id));
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(orderservice.getOrdersByUserId(userId));
	}
	@PutMapping("/{id}/status")
	public ResponseEntity<Order> updateStatus(@PathVariable Long id,@RequestParam OrderStatus status){
		return ResponseEntity.ok(orderservice.updateOrderStatus(id, status));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id){
		orderservice.deleteOrder(id);
		return ResponseEntity.ok("Order deleted successfully");
	}

}
