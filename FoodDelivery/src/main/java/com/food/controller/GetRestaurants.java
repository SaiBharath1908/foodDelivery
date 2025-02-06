package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.dao.dbutil.DBConnection;
import com.dao.impl.RestaurantDAOimpl;
import com.dao.interfaces.RestaurantDAO;
import com.dao.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class GetRestaurants
 */
//@WebServlet("/GetRestaurants")
public class GetRestaurants extends HttpServlet {
	
	private HttpSession session;
	private Connection con;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Cookie[] ck = req.getCookies();
		if(ck[0].getValue() != null) {
			try {
				con = DBConnection.connect();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			RestaurantDAO rdao = new RestaurantDAOimpl(con);
			ArrayList<Restaurant> rlist = rdao.fetchAll();
			session = req.getSession();
			
			session.setAttribute("Restaurants", rlist);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	}

}
