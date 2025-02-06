package com.dao.model;

public class CardItem {
	private int menu_id;
	private int restaurant_id;
	private String name;
	private int qunantity;
	private int price;
	
	
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQunantity() {
		return qunantity;
	}
	public void setQunantity(int qunantity) {
		this.qunantity = qunantity;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public CardItem() {
		super();
	}
	
	
	public CardItem(int menu_id, int restaurant_id, String name, int qunantity, int price) {
		super();
		this.menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.qunantity = qunantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return restaurant_id + "  " + name + "  " + price + "  " + qunantity + "  "+ menu_id;
	}
	

	
	
	

}
