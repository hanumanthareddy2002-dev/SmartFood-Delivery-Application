package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Food;
import com.nit.exception.FoodNotFoundException;
import com.nit.repository.FoodRepository;

@Service
public class FoodServiceImpl implements FoodService 
{
	@Autowired
	private FoodRepository foodrepository;

	@Override
	public Food createFood(Food food) {
		
		return foodrepository.save(food);
	}

	@Override
	public List<Food> getAllFood() {
		
		return foodrepository.findAll();
	}

	@Override
	public Food getFoodById(Long id) {
		
		return foodrepository.findById(id)
				.orElseThrow(()-> new FoodNotFoundException("Food not found with id: "+id));
	}

	@Override
	public List<Food> getFoodRestaurant(Long restaurantId) {
		
		return foodrepository.findByRestaurantId(restaurantId);
	}

	@Override
	public List<Food> getFoodByCategory(String category) {
		
		return foodrepository.findByCategory(category);
	}

	@Override
	public List<Food> getAvailableFood() {
		
		return foodrepository.findByAvailable(true);
	}

	@Override
	public List<Food> getAvailableFoodbyRestaurant(Long restaurantId) {
		
		return foodrepository.findByRestaurantIdAndAvailable(restaurantId, true);
	}

	@Override
	public Food updateFood(Long id, Food food) {
		Food exist=getFoodById(id);
		exist.setRestaurantId(food.getRestaurantId());
		exist.setName(food.getName());
		exist.setCategory(food.getCategory());
		exist.setPrice(food.getPrice());
		exist.setAvailable(food.getAvailable());
		return foodrepository.save(exist);
	}

	@Override
	public Food updateAvailability(Long id, Boolean available) {
		Food food=getFoodById(id);
		food.setAvailable(available);
		return foodrepository.save(food);
	}

	@Override
	public void deleteFood(Long id) {
		Food food=getFoodById(id);
		foodrepository.delete(food);

	}

}
