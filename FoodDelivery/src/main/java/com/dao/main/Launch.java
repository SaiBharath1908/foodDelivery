package com.dao.main;

import com.dao.model.User;

import java.sql.Connection;
import java.util.Scanner;

import com.dao.dbutil.DBConnection;
import com.dao.impl.UserDAOimpl;
import com.dao.interfaces.UserDAO;

public class Launch {

	static Scanner sc = new Scanner(System.in);
	private static Connection con;

	public static void main(String[] args) {
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		UserDAO udaoi = new UserDAOimpl(con);
		while(true) {
			System.out.println("Welcome to User data from Food App\nEnter the action you want to perform\n1.Insert user details\n"
					+ "2.View User list\n"
					+ "3.View specific user\n"
					+ "4.Update user details\n"
					+ "5.Delete user details\n"
					+ "6.Exit");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter user id");
				int id = sc.nextInt();
				
				
				System.out.println("Enter the username");
				String username = sc.nextLine();
				
				System.out.println("Enter the password");
				String password = sc.nextLine();
				
				System.out.println("Enter the email");
				String email = sc.nextLine();
			
				System.out.println("Enter the address");
				String address = sc.nextLine();
			
				System.out.println(udaoi.insert(new User(id , username,password,email,address))==1 ? "Data inserted" : "Data not inserted");
				break;
			
			case 2:
				for(User u: udaoi.fetchAll()) {
					System.out.println(u);
				}
				break;
				
			case 3:
				System.out.println("Enter email");
				sc.nextLine();
				email = sc.nextLine();
				System.out.println(udaoi.fetchOne(email));
				break;
				
			case 4:
				System.out.println("Enter user id");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter username");
				username = sc.nextLine();
				System.out.println( udaoi.update(id, username)==1 ? "Update success" : "update Failure");
				break;
				
			case 5:
				System.out.println("Enter the userid");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println(udaoi.delete(id)==1 ? "Deletion success " : "Deletion failure");
					
			case 6:
				System.out.println("Exiting");
				sc.close();
				return;
			}
		}

			
	}

}
