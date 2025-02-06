package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.Restaurant;

public interface RestaurantDAO {
	int insert(Restaurant r);
	ArrayList<Restaurant> fetchAll();
	Restaurant fetch(int id);
	int update(int id,float ratings);
	int delete(int id);

}
