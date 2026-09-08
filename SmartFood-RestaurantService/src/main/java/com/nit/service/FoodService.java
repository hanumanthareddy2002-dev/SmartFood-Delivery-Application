package com.nit.service;

import java.util.List;

import com.nit.entity.Food;

public interface FoodService {
	Food createFood(Food food);
	List<Food> getAllFood();
	Food getFoodById(Long id);
	List<Food> getFoodRestaurant(Long restaurantId);
	List<Food> getFoodByCategory(String category);
	List<Food> getAvailableFood();
	List<Food> getAvailableFoodbyRestaurant(Long restaurantId);
	Food updateFood(Long id, Food food);
	Food updateAvailability(Long id,Boolean available);
	void deleteFood(Long id);

}
