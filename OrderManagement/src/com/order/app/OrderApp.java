package com.order.app;

import java.util.Scanner;

import com.order.presentation.OrderPresentation;


public class OrderApp {

	public static void main(String[] args) {
		
		OrderPresentation orderPresentation= new OrderPresentation();
		
		
		Scanner sc= new Scanner(System.in);
		while(true) {
			orderPresentation.showMenu();
			int choice = sc.nextInt();
			orderPresentation.perform(choice);
			
			
			
		}

	}

}
