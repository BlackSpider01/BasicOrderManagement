package com.order.service;

import java.util.List;

import com.order.bean.Order;
import com.order.dao.OrderDao;
import com.order.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public boolean addOrder(Order order) {
		if(order.getOrderId()==0) {
			return false;
		}
		
		if(orderDao.addOrder(order)>0) {
			return true;
		}
		return false;

	}
	
	@Override
	public List<Order> viewAllOrders() {
		return orderDao.listOrder();
	}

	@Override
	public int updateOrder(Order order) {
		
		return orderDao.editOrder(order);
	}

	@Override
	public int deleteOrder(int orderId) {
		return orderDao.deleteOrder(orderId);
	}

	@Override
	public Order viewOrderById(int orderId) {
		
		return orderDao.viewOrder(orderId);
	}

}
