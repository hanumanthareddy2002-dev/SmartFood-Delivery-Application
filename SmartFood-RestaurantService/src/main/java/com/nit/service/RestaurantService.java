package com.nit.service;

import java.util.List;

import com.nit.entity.Restaurant;

public interface RestaurantService {
	Restaurant createRestaurant(Restaurant restaurant);
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(Long id);
	List<Restaurant> getRestaurantByCity(String city);
	List<Restaurant> searchRestaurant(String name);
	Restaurant updateRestaurant(Long id,Restaurant restaurant);
	void deleteRestaurant(Long id);
	List<Restaurant> getRestaurantByOwner(Long ownerId);
	
	

}
