package com.dao.model;

public class Menu {
	private int menu_id;
	private int restaurant_id;
	private String name;
	private String description;
	private int price;
	private int isAvailable;
	private String imagePath;

	// Getters and Setters
	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	// Constructor
	public Menu() {
		super();
	}


	public Menu(int menu_id, int restaurant_id, String name, String description, int price, int isAvailable, String imagePath) {
		this.menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return menu_id + "  " + name + "  " + description + "  " + price + "  " + isAvailable + "  " + imagePath;
	}
}
