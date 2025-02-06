package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.Menu;

public interface MenuDAO {
	int insert(Menu m);
    ArrayList<Menu> fetchAll();
    Menu fetch(int id);
    int update(int id, int price);
    int delete(int id);
    ArrayList<Menu> fetchMenuByRestaurantId(int restaurant_id);
}
