package com.food.controller;
import com.dao.dbutil.DBConnection;
import com.dao.impl.UserDAOimpl;
import com.dao.interfaces.UserDAO;
import com.dao.model.User;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



//@WebServlet("/Login")
public class Login extends HttpServlet {
	private Connection con;
	private static UserDAO udaoi ;
	private HttpSession session;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password").trim();
		String email = req.getParameter("email");
		session = req.getSession();
		

		try {
			con = DBConnection.connect();
			udaoi = new UserDAOimpl(con);
			User res = udaoi.fetchOne(email);

			if (res == null) {
				resp.getWriter().println("User not found");
			} else if ((res.getPassword().trim()).equals(password)) {
				session.setAttribute("loggedUser", res);
				session.setAttribute("name", res.getUsername());
				Cookie ck = new Cookie("email",email);
				req.getRequestDispatcher("GetRestaurants").include(req, resp);
			} else {
				resp.getWriter().println("password wrong");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
