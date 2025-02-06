package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.OrderItems;

public interface OrderItemsDAO {
	
	int insert(OrderItems order_item);          //for insertion data
	ArrayList<OrderItems> fetchAll();           //for fetching all the data from the table
	OrderItems fetch(int id);
	int update(int id, int quantity);
	int delete (int id);
}
