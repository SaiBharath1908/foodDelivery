package com.dao.impl;

import com.dao.interfaces.MenuDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.model.Menu;

public class MenuDAOimpl implements MenuDAO {
	 ArrayList<Menu> menu_list = new ArrayList<Menu>();
	    private Connection con;
	    
	    // SQL Queries
	    private static final String INSERT = "INSERT INTO menu (Menu_id, Restaurant_id, Name, Description, Price, isAvailable, imagePath) VALUES(?,?,?,?,?,?,?)";
	    private static final String FETCHALL = "SELECT * FROM menu";
	    private static final String FETCHONE = "SELECT * FROM menu WHERE Menu_id = ?";
	    private static final String UPDATE = "UPDATE menu SET Price = ? WHERE Menu_id = ?";
	    private static final String DELETE = "DELETE FROM menu WHERE Menu_id = ?";
	    private static final String FETCHMENU = "SELECT * FROM menu WHERE Restaurant_id = ?";
	    
	    public MenuDAOimpl(Connection con) {
	        this.con = con;
	    }

	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;
	    private Menu m;
		private ArrayList<Menu> menu_list_byRestaurant = new ArrayList<Menu>();

	    @Override
	    public int insert(Menu m) {
	        try {
	            pstmt = con.prepareStatement(INSERT);
	            pstmt.setInt(1, m.getMenu_id());
	            pstmt.setInt(2, m.getRestaurant_id());
	            pstmt.setString(3, m.getName());
	            pstmt.setString(4, m.getDescription());
	            pstmt.setInt(5, m.getPrice());
	            pstmt.setInt(6, m.getIsAvailable());
	            pstmt.setString(7, m.getImagePath());
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	        
	    }

	    @Override
	    public ArrayList<Menu> fetchAll() {
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FETCHALL);
	            menu_list = gettingOneFromResultset(resultSet);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menu_list;
	    }

	    @Override
	    public Menu fetch(int id) {
	        try {
	            pstmt = con.prepareStatement(FETCHONE);
	            pstmt.setInt(1, id);
	            resultSet = pstmt.executeQuery();
	            m = gettingOneFromResultset(resultSet).get(0);
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return m;
	    }

	    ArrayList<Menu> gettingOneFromResultset(ResultSet resultSet) {
	        try {
	            while (resultSet.next()) {
	                menu_list.add(new Menu(
	                    resultSet.getInt(1),
	                    resultSet.getInt(2),
	                    resultSet.getString(3),
	                    resultSet.getString(4),
	                    resultSet.getInt(5),
	                    resultSet.getInt(6),
	                    resultSet.getString(7)
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menu_list;
	    }

	    @Override
	    public int update(int id, int price) {
	        try {
	            pstmt = con.prepareStatement(UPDATE);
	            pstmt.setInt(1, price);
	            pstmt.setInt(2, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	        
	    }

	    @Override
	    public int delete(int id) {
	        try {
	            pstmt = con.prepareStatement(DELETE);
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return 0;
	        }
	        
	        
	       
	    }

	
		@Override
		public ArrayList<Menu> fetchMenuByRestaurantId(int restaurant_id) {
			try {
				pstmt = con.prepareStatement(FETCHMENU);
				pstmt.setInt(1, restaurant_id);
				resultSet = pstmt.executeQuery();
				 while (resultSet.next()) {
		                menu_list_byRestaurant.add(new Menu(
		                    resultSet.getInt(1),
		                    resultSet.getInt(2),
		                    resultSet.getString(3),
		                    resultSet.getString(4),
		                    resultSet.getInt(5),
		                    resultSet.getInt(6),
		                    resultSet.getString(7)
		                ));
				 }
		         return menu_list_byRestaurant;
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
}
