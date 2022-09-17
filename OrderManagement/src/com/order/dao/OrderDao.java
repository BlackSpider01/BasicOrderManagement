package com.order.dao;

import java.util.List;

import com.order.bean.Order;

public interface OrderDao {
	
	public int addOrder(Order order);
	public List<Order> listOrder();
	public int editOrder(Order order);
	public int deleteOrder(int orderId);
	public Order viewOrder(int orderId);
}
