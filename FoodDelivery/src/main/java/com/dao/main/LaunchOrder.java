package com.dao.main;

import com.dao.interfaces.OrdersDAO;
import com.dao.model.Orders;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.dao.dbutil.DBConnection;
import com.dao.impl.OrderDAOimpl;

public class LaunchOrder {
	static Scanner sc = new Scanner(System.in);
	private static Connection con;
	public static void main(String[] args) {
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		OrdersDAO odaoi = new OrderDAOimpl(con);
		
		while (true) {
            System.out.println("Welcome to Order Management\nSelect an option:\n1. Add Order\n2. View All Orders\n3. View Specific Order\n4. Update Order Status\n5. Delete Order\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.println("Enter order ID:");
                    int orderId = sc.nextInt();
                    
                    System.out.println("Enter User ID:");
                    int userId = sc.nextInt();
                    
                    System.out.println("Enter Restaurant ID:");
                    int restaurantId = sc.nextInt();
                    sc.nextLine();
                  
                    System.out.println("Enter Total Amount:");
                    float totalAmount = sc.nextFloat();
                    sc.nextLine();
                    
                    System.out.println("Enter Order Status:");
                    String status = sc.nextLine();
                    
                    System.out.println("Enter Payment Mode:");
                    String paymentMode = sc.nextLine();
                    
                    System.out.println("Enter Order Date (format: yyyy-MM-dd):");
                    String orderDateString = sc.nextLine();
                    
                    Date orderDate = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        orderDate = sdf.parse(orderDateString); // Parse the input date string into Date
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        return; // Exit if date format is invalid
                    }
                    System.out.println(odaoi.insert(new Orders(orderId , userId, restaurantId, totalAmount, status, paymentMode, orderDate)) == 1 ? "Order Added Successfully" : "Failed to Add Order");
                    break;

                case 2:
                    for (Orders o : odaoi.fetchAll()) {
                        System.out.println(o);
                    }
                    break;

                case 3:
                    System.out.println("Enter Order ID:");
                     orderId = sc.nextInt();
                    System.out.println(odaoi.fetch(orderId));
                    break;

                case 4:
                    System.out.println("Enter Order ID:");
                    orderId = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Enter New Status:");
                    String newStatus = sc.nextLine();
                    
                    System.out.println(odaoi.update(orderId, newStatus) == 1 ? "Status Updated" : "Failed to Update Status");
                    break;

                case 5:
                    System.out.println("Enter Order ID:");
                    orderId = sc.nextInt();
                    System.out.println(odaoi.delete(orderId) == 1 ? "Order Deleted" : "Failed to Delete Order");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
            }
		

	}

}
}
