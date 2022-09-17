package com.order.service;

import java.util.List;

import com.order.bean.Order;

public interface OrderService {
	
	public boolean addOrder(Order order);
	public List<Order> viewAllOrders();
	public int updateOrder(Order order);
	public int deleteOrder(int orderId);
	public Order viewOrderById(int orderId);
}
