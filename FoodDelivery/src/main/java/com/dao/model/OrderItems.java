package com.dao.model;

public class OrderItems {
	private int orderItem_id;
	private int order_id;
	private int menu_id;
	private int quantity;
	private int item_total;
	
	//setters and getters
	
	public int getOrder_id() {
		return order_id;
	}
	public int getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItem_total() {
		return item_total;
	}
	public void setItem_total(int item_total) {
		this.item_total = item_total;
	}
	//constructor
	public OrderItems() {
		super();
	}
	public OrderItems(int orderItem_id, int order_id, int menu_id, int quantity, int item_total) {
		super();
		this.orderItem_id = orderItem_id;
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.item_total = item_total;
	}
	//toString
	@Override
	public String toString() {
		return orderItem_id + "  " + order_id + "  " + menu_id
				+ "  " + quantity + "  " + item_total;
	}
	
	
	
	
	
}
