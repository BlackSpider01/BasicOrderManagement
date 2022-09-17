package com.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.bean.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int addOrder(Order order) {
		int res = 0;
		try(
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root" ,"1234" );){
			String query = "INSERT INTO orders values(?,?,?,?)";
			PreparedStatement stmt =con.prepareStatement(query);
			stmt.setInt(1, order.getOrderId());
			stmt.setDouble(2, order.getOrderTotal());
			stmt.setInt(3, order.getCustomerId());			
			stmt.setInt(4, order.getCartId());			
			
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return res;
	}

	@Override
	public List<Order> listOrder() {
		List<Order> listOrder= new ArrayList<Order>();
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root" ,"1234" );){
					String query = "SELECT * FROM ORDERS";
					PreparedStatement stmt =con.prepareStatement(query);			
					ResultSet resultSet = stmt.executeQuery();
					while(resultSet.next()) {
						int orderId=resultSet.getInt(1);
						double orderTotal=resultSet.getDouble(2);
						int customerId=resultSet.getInt(3);
						int cartId=resultSet.getInt(4);
						Order odr=new Order(orderId, orderTotal, customerId, cartId);
						listOrder.add(odr);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return listOrder;
				}
		return listOrder;
	}

	@Override
	public int editOrder(Order order) {
		int res=0;
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root" ,"1234" );){
					String query = "UPDATE ORDERS SET order_total=?,customer_id=?,cart_id=? WHERE order_id=?";
					PreparedStatement stmt =con.prepareStatement(query);
					stmt.setInt(4, order.getOrderId());
					stmt.setDouble(1, order.getOrderTotal());
					stmt.setInt(2, order.getCustomerId());			
					stmt.setInt(3, order.getCartId());			
					
					res = stmt.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
					return 0;
				}
		
		return res;
	}

	@Override
	public int deleteOrder(int orderId) {
		int res=0;
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root" ,"1234" );){
					String query = "DELETE FROM ORDERS WHERE order_id=?";
					PreparedStatement stmt =con.prepareStatement(query);
					stmt.setInt(1, orderId);
					
					res = stmt.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
					return 0;
				}
		
		return res;
	}

	@Override
	public Order viewOrder(int orderId) {
		Order odr=null;
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ordermanagement", "root" ,"1234" );){
					String query = "SELECT * FROM ORDERS WHERE order_id=?";
					PreparedStatement stmt =con.prepareStatement(query);	
					stmt.setInt(1, orderId);
					ResultSet resultSet = stmt.executeQuery();
					if(resultSet.next()) {
						orderId=resultSet.getInt(1);
						double orderTotal=resultSet.getDouble(2);
						int customerId=resultSet.getInt(3);
						int cartId=resultSet.getInt(4);
						odr=new Order(orderId, orderTotal, customerId, cartId);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
		return odr;
		
	}

}
