package com.dao.main;

import com.dao.model.Restaurant;
import com.dao.interfaces.RestaurantDAO;

import java.sql.Connection;
import java.util.Scanner;

import com.dao.dbutil.DBConnection;
import com.dao.impl.RestaurantDAOimpl;

public class restaurant_launch {
	static Scanner sc = new Scanner(System.in);
	private static Connection con;
	public static void main(String[] args) {
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		RestaurantDAO rdaoi = new RestaurantDAOimpl(con);
		while(true) {
		System.out.println("Welcome to Restaurant data from Food App\nEnter the action you want to perform\n1.Insert restaurant details\n"
				+ "2.View restaurant list\n"
				+ "3.View specific restaurant detail\n"
				+ "4.Update restaurant details\n"
				+ "5.Delete restaurant details\n"
				+ "6.Exit");
		
		
			int c = sc.nextInt();
			switch(c)
			{
			case 1:
				System.out.println("Enter the restaurant_id");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the restaurant name");
				String name = sc.nextLine();
				
				System.out.println("Enter the cuisine name");
				String cuisine = sc.nextLine();
				
				System.out.println("Enter the delivery time");
				String deliveryTime = sc.nextLine();
				sc.nextLine();
				
				System.out.println("Enter the address");
				String address = sc.nextLine();
				
				System.out.println("Enter ratings");
				Float ratings = sc.nextFloat();
				
				System.out.println("Is it available or not");
				int isActive = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the imagePath");
				String imagePath = sc.nextLine();
				
				System.out.println(rdaoi.insert(new Restaurant(id,name,cuisine,deliveryTime,address,ratings,isActive,imagePath)) == 1 ? "Insertion successful" : "Insertion is failed");
				break;
				
			case 2:
				for( Restaurant r : rdaoi.fetchAll()) {
					System.out.println(r);
				}
				break;
				
			case 3:
				System.out.println("Enter the restaurant_id");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println(rdaoi.fetch(id));
				break;
				
			case 4:
				System.out.println("Enter the restaurant_id");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter ratings");
				ratings = sc.nextFloat();
				System.out.println(rdaoi.update(id, ratings)== 1 ? "Updation successful" : "Updation is failed");
				break;
				
			case 5:
				System.out.println("Enter the restaurant_id");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println(rdaoi.delete(id)== 1 ? "Deletion successful" : "Deletion is failed");
				
			case 6:
				System.out.println("exiting");
				sc.close();
				return;
			}
		}
//		
		
		
		
	}
}
