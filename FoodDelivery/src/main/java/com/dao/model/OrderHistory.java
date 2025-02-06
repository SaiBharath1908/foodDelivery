package com.dao.model;

import java.sql.Date;

public class OrderHistory {
		private int orderhistory_id;
	    private int orderId;
	    private int userId;
	    private double totalAmount;
	    private String status;
	    private Date orderDate;

	    // Constructor
	    public OrderHistory() {
	    	super();
	    }
	    
	    public OrderHistory(int orderhistory_id,int orderId, int userId, double totalAmount, String status, Date orderDate) {
	    	this.orderhistory_id = orderhistory_id;
	        this.orderId = orderId;
	        this.userId = userId;
	        this.totalAmount = totalAmount;
	        this.status = status;
	        this.orderDate = orderDate;
	    }

	    // Getters and Setters
	    
	    
	    public int getOrderId() {
	        return orderId;
	    }

	    public int getOrderhistory_id() {
			return orderhistory_id;
		}

		public void setOrderhistory_id(int orderhistory_id) {
			this.orderhistory_id = orderhistory_id;
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

	    public Date getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(Date date) {
	        this.orderDate = date;
	    }

	    @Override
	    public String toString() {
	        return orderhistory_id + "  " + orderId + " " + userId + " " + totalAmount + " " + status + " " + orderDate;
	    }

		
	}


