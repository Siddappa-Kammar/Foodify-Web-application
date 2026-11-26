package com.tap.model;

import java.sql.Timestamp;

public class Menu {
	
	private int menuId;
	private int restId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvailable;
	private String category;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;
	private String imagePath;
	
	public Menu(int menuId, int restId, String itemName, String description, double price, boolean isAvailable,
			String category, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String imagePath) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.imagePath = imagePath;
	}
	
	public Menu() {
		super();
	}


	public Menu(int restId, String itemName, String description, double price, boolean isAvailable, String category, String imagePath) {
		super();
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
		this.imagePath = imagePath;
		
	}




	public Menu(int restId, String itemName, String description, double price, boolean isAvailable, String category,
			Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String imagePath) {
		super();
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.category = category;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restId=" + restId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", category=" + category
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	
}
