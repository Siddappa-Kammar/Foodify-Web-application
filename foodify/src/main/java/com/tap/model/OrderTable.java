package com.tap.model;

import java.sql.Timestamp;

public class OrderTable {

	private int orderId;
	private int userId;
	private int restId;
	private Timestamp orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethod;
	
	
	public OrderTable() {
		super();
	}

	public OrderTable(int orderId, int userId, int restId, Timestamp orderDate, double totalAmount, String status,
			String paymentMethod) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restId = restId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}



	public OrderTable(int userId, int restId, Timestamp orderDate, double totalAmount, String status,
			String paymentMethod) {
		super();
		this.userId = userId;
		this.restId = restId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}


	public OrderTable(int userId, int restId, double totalAmount, String status, String paymentMethod) {
		super();
		this.userId = userId;
		this.restId = restId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}

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

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "OrderTable [orderId=" + orderId + ", userId=" + userId + ", restId=" + restId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ "]";
	}
	
	
}
