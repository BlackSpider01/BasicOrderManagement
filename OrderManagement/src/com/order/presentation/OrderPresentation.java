package com.order.presentation;

import java.util.List;
import java.util.Scanner;

import com.order.bean.Order;
import com.order.service.OrderService;
import com.order.service.OrderServiceImpl;

public class OrderPresentation {
	OrderService orderService= new OrderServiceImpl();
	
	public void showMenu() {
	
		System.out.println("Enter Your Choice");
		System.out.println("1. Add Order");
		System.out.println("2. Edit Order");
		System.out.println("3. Delete Order");
		System.out.println("4. View Order");
		System.out.println("5. List Order");
		System.out.println("6. EXIT");
	}
	
	public void perform(int choice) {
		Scanner sc= new Scanner(System.in);
		switch (choice) {
		case 1: System.out.println("Enter Order Details");
				System.out.println("Enter OrderId: ");
				int id = sc.nextInt();
				System.out.println("Enter OrderTotal: ");
				double total = sc.nextDouble();
				System.out.println("Enter CustomerId: ");
				int cust = sc.nextInt();
				System.out.println("Enter CartId: ");
				int cart = sc.nextInt();
				Order order = new Order(id, total, cust, cart);
				if(orderService.addOrder(order)==true) {
					System.out.println("order added sucessfully");
				}
				else {
					System.out.println("Unable To ADD Order");
				}
				break;
		case 2: System.out.println("Enter order id to Update Order details: ");
				id=sc.nextInt();
				System.out.println("Enter OrderTotal: ");
				total = sc.nextDouble();
				System.out.println("Enter CustomerId: ");
				cust = sc.nextInt();
				System.out.println("Enter CartId: ");
				cart = sc.nextInt();
				order = new Order(id, total, cust, cart);
				if(orderService.updateOrder(order)>0) {
					System.out.println("Updated Sucessfully");
					for(Order i:orderService.viewAllOrders()) {
						System.out.println(i);
					}
				}else {
					System.err.println("Unable to Update");
				}
				
				break;
		case 3: System.out.println("Enter Order Id To Delete Order: ");
				id=sc.nextInt();
				if(orderService.deleteOrder(id)>0) {
					System.out.println("Deleted Sucessfully");
					for(Order i:orderService.viewAllOrders()) {
						System.out.println(i);
					}
				}else {
					System.err.println("Unable to delete");
				}
				break;
		case 4: System.out.println("Enter Order Id : ");
				id=sc.nextInt();
				Order res=orderService.viewOrderById(id);
				
				if(res!=null)
					System.out.println(res);
				else
					System.out.println("No order found for order id:"+id);
				break;
		case 5: System.out.println("List all orders:- ");
				List<Order> list = orderService.viewAllOrders();
				for(Order order1:list) {
					System.out.println(order1);
				}
				//System.out.println(list);
				break;
		case 6: System.out.println("Thanks for Using Order Management System");
				System.exit(0);
		default: System.out.println("Enter Valid Choice");
				break;
		}
	}
	

}
