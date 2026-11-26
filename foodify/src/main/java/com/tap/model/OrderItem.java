package com.tap.model;

public class OrderItem  {
	
	private int OIid;
	private int orderId;
	private int menuId;
	private int quantity;
	private double itemTotal;
	
	// extra added for the orders table showing
	private String itemName;   
	private double unitPrice;
	private String imagePath;
	
	
	public OrderItem() {
		super();
	}


	public OrderItem(int oIid, int orderId, int menuId, int quantity, double itemTotal) {
		super();
		OIid = oIid;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}


	public OrderItem(int orderId, int menuId, int quantity, double itemTotal) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}


	public int getOIid() {
		return OIid;
	}


	public void setOIid(int oIid) {
		OIid = oIid;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getItemTotal() {
		return itemTotal;
	}


	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
		
	public String getItemName() {
	    return itemName;
	}
	
	public void setItemName(String itemName) {
	    this.itemName = itemName;
	}
	
	public double getUnitPrice() {
	    return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
	    this.unitPrice = unitPrice;
	}
	
	public String getImagePath() {
	    return imagePath;
	}
	
	public void setImagePath(String imagePath) {
	    this.imagePath = imagePath;
	}



	@Override
	public String toString() {
		return "OrderItem [OIid=" + OIid + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity=" + quantity
				+ ", itemTotal=" + itemTotal + "]";
	}
	
	

}
