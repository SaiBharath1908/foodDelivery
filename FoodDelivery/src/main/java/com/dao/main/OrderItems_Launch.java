package com.dao.main;

import java.sql.Connection;
import java.util.Scanner;
import com.dao.interfaces.OrderItemsDAO;
import com.dao.model.OrderItems;
import com.dao.dbutil.DBConnection;
import com.dao.impl.OrderItemsDAOimpl;

public class OrderItems_Launch {
	static Scanner sc = new Scanner(System.in);
	private static Connection con;
	
	public static void main(String[] args) {
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		OrderItemsDAO order_Item = new OrderItemsDAOimpl(con);
		while (true) {
			System.out.println("Welcome to Order Items data from Food App\nEnter the action you want to perform\n"
					+ "1. Insert order item\n"
					+ "2. View order items list\n"
					+ "3. View specific order item detail\n"
					+ "4. Update order item details\n"
					+ "5. Delete order item details\n"
					+ "6. Exit");

			int c = sc.nextInt();
			switch (c) {
			case 1:
				// Insert Order Item
				System.out.println("Enter OrderItem_Id:");
				int orderItem_id = sc.nextInt();
				
				System.out.println("Enter OrderId:");
				int orderId = sc.nextInt();

				System.out.println("Enter MenuId:");
				int menuId = sc.nextInt();

				System.out.println("Enter Quantity:");
				int quantity = sc.nextInt();

				System.out.println("Enter ItemTotal:");
				int itemTotal = sc.nextInt();

				System.out.println(order_Item.insert( new OrderItems(orderItem_id, orderId, menuId, quantity, itemTotal)) == 1 ? "Insertion successful" : "Insertion is failed");

				break;

			case 2:
				// View all Order Items
				System.out.println("Fetching all Order Items...");
				for(OrderItems o: order_Item.fetchAll()) {
					System.out.println(o);
				}
				break;

			case 3:
				// View specific Order Item
				System.out.println("Enter OrderItemId to view:");
				orderItem_id = sc.nextInt();
				System.out.println(order_Item.fetch(orderItem_id));

				break;

			case 4:
				// Update Order Item
				System.out.println("Enter OrderItemId to update:");
				orderItem_id = sc.nextInt();

				System.out.println("Enter new Quantity:");
				quantity = sc.nextInt();
				System.out.println(order_Item.update(orderItem_id, quantity) == 1 ? "Updation Successful" : "Updation is failed");

				break;

			case 5:
				// Delete Order Item
				System.out.println("Enter OrderItemId to delete:");
				orderItem_id = sc.nextInt();
				System.out.println(order_Item.delete(orderItem_id) == 1 ? "Updation Successful" : "Updation is failed");
				break;

			case 6:
				System.out.println("Exiting...");
				sc.close();
				return; // Exit the program
			}






		}

	}
}
