package com.dao.main;

import com.dao.model.OrderHistory;
import com.dao.interfaces.OrderHistoryDAO;
import com.dao.dbutil.DBConnection;
import com.dao.impl.OrderHistoryDAOimpl;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Scanner;

public class OrderHistory_Launch {
    static Scanner sc = new Scanner(System.in);
	private static Connection con;

    public static void main(String[] args) {
    	try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDAOimpl(con);

        while (true) {
            System.out.println("Welcome to Order History Management");
            System.out.println("1. Insert Order History");
            System.out.println("2. View All Order Histories");
            System.out.println("3. View Specific Order History");
            System.out.println("4. Update Order History Status");
            System.out.println("5. Delete Order History");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                	System.out.println("Enter Orderhistory_Id:");
                    int orderhistory_id = sc.nextInt();
                	
                    System.out.println("Enter Order_Id:");
                    int orderId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter User_Id:");
                    int userId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter Total Amount:");
                    Double totalAmount = sc.nextDouble();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter Status:");
                    String status = sc.nextLine();
                    System.out.println("Enter Order Date (format: yyyy-MM-dd):");
                    String orderDateString = sc.nextLine();
                    
                    Date orderDate = null;
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date utilDate = sdf.parse(orderDateString); // Parse the input date string into java.util.Date
                        orderDate = new Date(utilDate.getTime()); // Convert to java.sql.Date
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        return; // Exit if date format is invalid
                    }

                 
                    System.out.println(orderHistoryDAO.insert(new OrderHistory(orderhistory_id , orderId, userId, totalAmount, status, orderDate)) == 1 ? "Insertion Successful" : "Insertion Failed");
                    break;

                case 2:
                    for (OrderHistory oh : orderHistoryDAO.fetchAll()) {
                        System.out.println(oh);
                    }
                    break;

                case 3:
                    System.out.println("Enter OrderHistory_Id:");
                    int fetchId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.println(orderHistoryDAO.fetch(fetchId));
                    break;

                case 4:
                    System.out.println("Enter OrderHistory_Id:");
                    int updateId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.println("Enter New Status:");
                    String newStatus = sc.nextLine();
                    System.out.println(orderHistoryDAO.updateStatus(updateId, newStatus) == 1 ? "Update Successful" : "Update Failed");
                    break;

                case 5:
                    System.out.println("Enter OrderHistory_Id:");
                    int deleteId = sc.nextInt();
                    sc.nextLine();  // Consume newline
                    System.out.println(orderHistoryDAO.delete(deleteId) == 1 ? "Deletion Successful" : "Deletion Failed");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
