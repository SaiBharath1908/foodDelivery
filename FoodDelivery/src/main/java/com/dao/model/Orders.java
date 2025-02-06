package com.dao.model;

import java.util.Date;

//import java.util.Date;

public class Orders {
	private int orderId;
	private int userId;
	private int restaurantId;
	private double totalAmount;
	private String status;
	private String paymentMode;
	private Date order_date;


	//setters and getters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	
	}
	
	
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date orderDate) {
		this.order_date = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	//constructor
	public Orders() {
		super();
	}
	
	public Orders(int orderId , int userId, int restaurantId, double totalAmount, String status, String paymentMode,
			Date order_date) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return orderId + "  "+ userId + "  " + restaurantId + "  " + totalAmount + "  " + status + "  " + paymentMode +"  "+order_date;
	}
	
	


	

}
