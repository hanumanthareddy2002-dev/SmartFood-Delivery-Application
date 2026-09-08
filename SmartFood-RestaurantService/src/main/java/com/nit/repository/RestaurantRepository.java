package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>
{
	List<Restaurant> findByCity(String city);
	List<Restaurant> findByActiveTrue();
	List<Restaurant> findByNameContainingIgnoreCase(String name);
	List<Restaurant> findByOwnerId(Long ownerId);

}
