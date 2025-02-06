package com.dao.interfaces;

import java.util.ArrayList;

import com.dao.model.OrderHistory;

public interface OrderHistoryDAO {
	int insert(OrderHistory orderHistory);
    ArrayList<OrderHistory> fetchAll();
    OrderHistory fetch(int orderHistoryId);
    int updateStatus(int orderHistoryId, String status);
    int delete(int orderHistoryId);
}
