package com.food.controller;

import java.io.IOException;
import java.sql.Connection;

import com.dao.dbutil.DBConnection;
import com.dao.impl.UserDAOimpl;
import com.dao.interfaces.UserDAO;
import com.dao.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
	private UserDAO udaoi;
	private Connection con;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String password = req.getParameter("password");
		
		if(password.equals(req.getParameter("cpassword"))) {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String address = req.getParameter("address");
			try {
				con = DBConnection.connect();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			udaoi = new UserDAOimpl(con);
			User u = new User(0,username,password,email,address);
			
			if(udaoi.insert(u) != 0) {
				resp.sendRedirect("login.jsp");
			}
		}
		else {
			resp.getWriter().println("Password Mismatch");		}
	}

}
