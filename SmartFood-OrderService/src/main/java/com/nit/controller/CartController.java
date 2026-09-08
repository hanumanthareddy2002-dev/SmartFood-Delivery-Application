package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Cart;
import com.nit.entity.CartItem;
import com.nit.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartservice;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Cart> getCart(@PathVariable Long userId){
		return ResponseEntity.ok(cartservice.getCartByUserId(userId));
	}
	
	@PostMapping("/{userId}/items")
	public ResponseEntity<Cart> addItem(@PathVariable Long userId,@RequestBody CartItem item){
		return ResponseEntity.ok(cartservice.addItem(userId, item));
	}
	
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<String> removeItem(@PathVariable Long itemId){
		cartservice.removeItem(itemId);
		return ResponseEntity.ok("cart item removed successfully");
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> clearCart(@PathVariable Long userId){
		cartservice.clearCart(userId);
		return ResponseEntity.ok("cart cleared successfully");
	}
	
}
