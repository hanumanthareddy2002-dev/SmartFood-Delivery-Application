package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long>
{
	List<Food> findByRestaurantId(Long restaurantId);
	List<Food> findByCategory(String category);
	List<Food> findByAvailable(Boolean available);
	List<Food> findByRestaurantIdAndAvailable(Long restaurantId,Boolean available);

}
