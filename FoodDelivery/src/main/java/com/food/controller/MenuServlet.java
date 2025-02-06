package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.LinkedTransferQueue;

import com.dao.dbutil.DBConnection;
import com.dao.impl.MenuDAOimpl;
import com.dao.interfaces.MenuDAO;
import com.dao.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




//@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private ArrayList<Menu> menu_list;
	private Connection con;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt( req.getParameter("restaurantId"));
		req.getSession().setAttribute("restaurantId", id);
		try {
			con = DBConnection.connect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		MenuDAO m = new MenuDAOimpl(con);
		menu_list = m.fetchMenuByRestaurantId(id);
		req.setAttribute("menus", menu_list);
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
		
}
}
