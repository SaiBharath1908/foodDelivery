package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.interfaces.RestaurantDAO;
import com.dao.model.Restaurant;

public class RestaurantDAOimpl implements RestaurantDAO {
	ArrayList<Restaurant> restaurant_list = new ArrayList<Restaurant>();
	private Connection con;
	private static final String INSERT = " INSERT INTO restaurant (restaurant_id, Name, cuisineType, deliveryTime, address, ratings, isActive, imagePath)"
										+" VALUES(?,?,?,?,?,?,?,?)";
	
	private static final String FETCHAll = "select * from restaurant";
	private static final String FETCHONE = "select * from restaurant where restaurant_id = ?";
	private static final String UPDATE = "update restaurant set ratings = ? where restaurant_id = ?";
	private static final String DELETE = "delete from restaurant where restaurant_id = ?";
	
	
	public RestaurantDAOimpl(Connection con) {
        this.con = con;
    }

	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private Restaurant r;

	@Override
	public int insert(Restaurant r) {
		try {
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, r.getRestaurant_id());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getDeliveryTime());
			pstmt.setString(5, r.getAddress());
			pstmt.setFloat(6, r.getRatings());
			pstmt.setInt(7, r.getIsActive());
			pstmt.setString(8 , r.getImagePath());
			
			return pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Restaurant> fetchAll() {
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FETCHAll);
			restaurant_list = gettingOneFromResultset(resultSet);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurant_list;
	}

	@Override
	public Restaurant fetch(int id) {
		try {
			pstmt = con.prepareStatement(FETCHONE);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			r = gettingOneFromResultset(resultSet).get(0);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	ArrayList<Restaurant> gettingOneFromResultset(ResultSet resultSet) {
		try {
			while(resultSet.next()) {
				restaurant_list.add(new Restaurant(resultSet.getInt(1) ,
				resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4) , resultSet.getString(5) ,
				resultSet.getFloat(6) , resultSet.getInt(7) , resultSet.getString(8)
				) );
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurant_list;
	}

	@Override
	public int update(int id, float ratings) {
		try {
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setFloat(1, ratings);
			pstmt.setInt(2, id);
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
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
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
