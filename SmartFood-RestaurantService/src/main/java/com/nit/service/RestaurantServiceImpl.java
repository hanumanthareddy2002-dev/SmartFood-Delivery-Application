package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Restaurant;
import com.nit.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
	@Autowired
	private RestaurantRepository restaurantrepo;

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		restaurant.setActive(true);
		if(restaurant.getRating()==null) {
			restaurant.setRating(0.0);
		}
		return restaurantrepo.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		return restaurantrepo.findByActiveTrue();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		
		return restaurantrepo.findById(id).orElseThrow(()->
		          new RuntimeException("Restaurant not found with id : "+id));
	}

	@Override
	public List<Restaurant> getRestaurantByCity(String city) {
		
		return restaurantrepo.findByCity(city);
	}

	@Override
	public List<Restaurant> searchRestaurant(String name) {
		
		return restaurantrepo.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
		Restaurant exist=getRestaurantById(id);
		exist.setName(restaurant.getName());
		exist.setAddress(restaurant.getAddress());
		exist.setCity(restaurant.getCity());
		exist.setPhone(restaurant.getPhone());
		
		if(restaurant.getRating()!=null) {
			exist.setRating(restaurant.getRating());
		}
		if(restaurant.getActive()!=null) {
			exist.setActive(restaurant.getActive());
		}
		if(restaurant.getOwnerId()!=null) {
			exist.setOwnerId(restaurant.getOwnerId());
		}
		
		
		return restaurantrepo.save(exist);
	}

	@Override
	public void deleteRestaurant(Long id) {
		Restaurant restaurant=getRestaurantById(id);
		restaurant.setActive(false);
		restaurantrepo.save(restaurant);
		
	}

	@Override
	public List<Restaurant> getRestaurantByOwner(Long ownerId) {
		
		return restaurantrepo.findByOwnerId(ownerId);
	}
	

}
