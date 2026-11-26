package com.tap.model;


public class Restaurant {
	
	private int RestId;
	private String name;
	private String CuisineType;
	private int DeliveryTime;
	private String Address;
	private int AdminUserId;
	private Double rating;
	private int isActive;
	private String imagePath;
	
	
	
	
	
	public Restaurant() {
		super();
	}


	public Restaurant(int restId, String name, String cuisineType, int deliveryTime, String address,
			int adminUserId, Double rating, int isActive, String imagePath) {
		super();
		RestId = restId;
		this.name = name;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		Address = address;
		AdminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}

	
	public Restaurant(String name, String cuisineType, String address, int adminUserId, Double rating, int isActive, String imagePath) {
		super();
		this.name = name;
		CuisineType = cuisineType;
		Address = address;
		AdminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}


	public int getRestId() {
		return RestId;
	}


	public void setRestId(int restId) {
		this.RestId = restId;
	}


	public String getName() {
		return name;
	}


	public Restaurant(String name, String cuisineType, int deliveryTime, String address, int adminUserId, Double rating,
			int isActive, String imagePath) {
		super();
		this.name = name;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		Address = address;
		AdminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCuisineType() {
		return CuisineType;
	}


	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}


	public int getDeliveryTime() {
		return DeliveryTime;
	}


	public void setDeliveryTime(int deliveryTime) {
		this.DeliveryTime = deliveryTime;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public int getAdminUserId() {
		return AdminUserId;
	}


	public void setAdminUserId(int adminUserId) {
		AdminUserId = adminUserId;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
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

	
	@Override
	public String toString() {
		return "Restaurant [RestId=" + RestId + ", name=" + name + ", CuisineType=" + CuisineType + ", DeliveryTime="
				+ DeliveryTime + ", Address=" + Address + ", AdminUserId=" + AdminUserId + ", rating=" + rating
				+ ", isActive=" + isActive + "]";
	}
	
	
	
}
