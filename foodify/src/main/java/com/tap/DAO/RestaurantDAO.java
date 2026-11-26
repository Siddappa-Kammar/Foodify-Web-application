package com.tap.DAO;

import java.util.*;

import com.tap.model.Restaurant;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant rest);
	Restaurant getRestaurant(int id);
	void updateRestaurant(Restaurant rest);
	void deleteRestaurant(int id);
	List<Restaurant> getAllRestaurant();

}
