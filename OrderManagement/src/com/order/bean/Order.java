package com.order.bean;

public class Order {
	private int orderId;
	private double orderTotal;
	private int customerId;
	private int cartId;
	
	public Order(int orderId, double orderTotal, int customerId, int cartId) {
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.customerId = customerId;
		this.cartId = cartId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderTotal=" + orderTotal + ", customerId=" + customerId + ", cartId="
				+ cartId + "]";
	}
	

}