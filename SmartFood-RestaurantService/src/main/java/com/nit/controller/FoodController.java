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

import com.nit.entity.Food;
import com.nit.service.FoodService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/foods")
public class FoodController {
	@Autowired
	private FoodService foodservice;
	
	@PostMapping
	public ResponseEntity<Food> createFood(@Valid @RequestBody Food food){
		Food saved=foodservice.createFood(food);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Food>> getAllFood(){
		return ResponseEntity.ok(foodservice.getAllFood());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable Long id){
		return ResponseEntity.ok(foodservice.getFoodById(id));
	}
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>> getFoodByRestaurant(@PathVariable Long restaurantId){
		return ResponseEntity.ok(foodservice.getFoodRestaurant(restaurantId));
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Food>> getFoodByCategory(@PathVariable String category){
		return ResponseEntity.ok(foodservice.getFoodByCategory(category));
	}
	
	@GetMapping("/available")
	public ResponseEntity<List<Food>> getAvailableFood(){
		return ResponseEntity.ok(foodservice.getAvailableFood());
	}
	
	@GetMapping("/restaurant/{restaurantId}/available")
	public ResponseEntity<List<Food>> getAvailableFoodByRestaurant(@PathVariable Long restaurantId){
		return ResponseEntity.ok(foodservice.getAvailableFoodbyRestaurant(restaurantId));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable Long id,@Valid @RequestBody Food food){
		return ResponseEntity.ok(foodservice.updateFood(id, food));
	}
	
	@PutMapping("/{id}/availability")
	public ResponseEntity<Food> updateAvailability(@PathVariable Long id, @RequestParam Boolean available){
		return ResponseEntity.ok(foodservice.updateAvailability(id, available));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFood(@PathVariable Long id){
		foodservice.deleteFood(id);
		return ResponseEntity.ok("Food deleted successfully");
	}

	

}
