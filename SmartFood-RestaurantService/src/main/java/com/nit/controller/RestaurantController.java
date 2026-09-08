package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Restaurant;
import com.nit.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins="http://localhost:5173")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantservice;
    
	@PostMapping
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant)
	{
		return ResponseEntity.ok(restaurantservice.createRestaurant(restaurant));
	}
	@GetMapping
	public ResponseEntity<List<Restaurant>> getAllRestaurant()
	{
		return ResponseEntity.ok(restaurantservice.getAllRestaurants());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id)
	{
		return ResponseEntity.ok(restaurantservice.getRestaurantById(id));
	}
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Restaurant>> getByCity(@PathVariable String city)
	{
		return ResponseEntity.ok(restaurantservice.getRestaurantByCity(city));
	}
	@GetMapping("/search")
	public ResponseEntity<List<Restaurant>> search(@RequestParam String name)
	{
		return ResponseEntity.ok(restaurantservice.searchRestaurant(name));
	}
	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Restaurant>> getByOwner( @PathVariable Long ownerId)
	{

	    return ResponseEntity.ok( restaurantservice.getRestaurantByOwner(ownerId));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,@RequestBody Restaurant restaurant)
	{
		return ResponseEntity.ok(restaurantservice.updateRestaurant(id, restaurant));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable Long id)
	{
		restaurantservice.deleteRestaurant(id);
		return ResponseEntity.ok("Restaurant deleted successfully");
	}
}
