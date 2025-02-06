package com.dao.model;

public class Restaurant {
	private int restaurant_id;
	private String Name;
	private String cuisineType;
	private String deliveryTime;
	private String address;
	private float ratings;
	private int isActive;
	private String imagePath;
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Restaurant() {
		super();
		
	}
	public Restaurant(int restaurant_id, String name, String cuisineType, String deliveryTime, String address,
			float ratings, int isActive, String imagePath) {
		super();
		this.restaurant_id = restaurant_id;
		Name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return restaurant_id + "  " + Name + "  " + cuisineType
				+ "  " + deliveryTime + "  " + address + "  " + ratings + "  "
				+ isActive + "  " + imagePath;
	}
	
	

}
