package com.dao.main;
import com.dao.model.Menu;
import com.dao.interfaces.MenuDAO;
import com.dao.dbutil.DBConnection;
import com.dao.impl.MenuDAOimpl;

import java.sql.Connection;
import java.util.Scanner;

public class menu_launch {
	static Scanner sc = new Scanner(System.in);
	private static  Connection con;
	public static void main(String[] args) {
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		MenuDAO menuDAO = new MenuDAOimpl(con);

		while (true) {
			System.out.println("Welcome to Menu Management\nEnter the action you want to perform\n"
					+ "1. Insert Menu Item\n"
					+ "2. View Menu List\n"
					+ "3. View Specific Menu Item\n"
					+ "4. Update Menu Item Price\n"
					+ "5. Delete Menu Item\n"
					+ "6. Menu list by Restaurant Id\n"
					+ "7. Exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Menu ID:");
				int id = sc.nextInt();
				
				System.out.println("Enter Restaurant ID:");
				int restaurantId = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Menu Name:");
				String name = sc.nextLine();
				
				System.out.println("Enter Description:");
				String description = sc.nextLine();
				
				System.out.println("Enter Price:");
				int price = sc.nextInt();
				
				System.out.println("Is Available (1 for Yes, 0 for No):");
				int isAvailable = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Image Path:");
				String imagePath = sc.nextLine();

		
				System.out.println(menuDAO.insert(new Menu(id, restaurantId, name, description, price, isAvailable, imagePath)) == 1 ? "Insertion Successful" : "Insertion Failed");
				break;

			case 2:
				for (Menu m : menuDAO.fetchAll()) {
					System.out.println(m);
				}
				break;

			case 3:
				System.out.println("Enter Menu ID:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println( menuDAO.fetch(id));
				break;

			case 4:
				System.out.println("Enter Menu ID:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter New Price:");
				price = sc.nextInt();
				sc.nextLine();
				
				System.out.println(menuDAO.update(id, price) == 1 ? "Update Successful" : "Update Failed");
				break;

			case 5:
				System.out.println("Enter Menu ID:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println(menuDAO.delete(id) == 1 ? "Deletion Successful" : "Deletion Failed");
				break;

			case 6:
				System.out.println("Enter Restaurant ID:");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println( menuDAO.fetchMenuByRestaurantId(id));
				break;
				
			case 7:
				System.out.println("Exiting...");
				sc.close();
				return;

			}
		}
	}

}

